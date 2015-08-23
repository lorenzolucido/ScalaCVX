package org.scalacvx

import org.scalacvx.atoms.Expression
import org.scalacvx.conic.ConicForm
import org.scalacvx.constraints.Constraint
import org.scalacvx.dcp.{AffineVexity, ConvexVexity, ConstantVexity, Vexity}


case class Problem(problemType: ProblemType, objective: Expression, constraints:Array[Constraint]) {
  // In Convex.jl, the problem class contains the solution. Can we do better ?

  def vexity:Vexity = {
    val objectiveVex = if(problemType == MinimizationProblem) objective.vexity else -objective.vexity
    val constraintVex = constraints.map(c => c.vexity).foldLeft[Vexity](ConstantVexity) {(a, b) => a + b }

    objectiveVex + constraintVex match {
      case ConvexVexity | AffineVexity => objectiveVex + constraintVex
      case _ => throw new Exception("Problem not DCP compliant")
    }
  }

  // The conic form of the problem reduces to convert the objective to a linear function
  // and the constraints to linear inequalities or inclusion in convex cone
  lazy val conicForm:ConicForm = {
    if(objective.vexity == AffineVexity && constraints.forall(c => c.vexity == AffineVexity)) ConicForm(objective,constraints)
    else ???
  }


  def subjectTo(const:Constraint) = Problem(problemType, objective, constraints :+ const)
  def subjectTo(consts:Array[Constraint]) = Problem(problemType, objective, constraints ++ consts)
}

object Problem {
  def minimize(expr:Expression) = Problem(MinimizationProblem, expr, Array[Constraint]())
  def maximize(expr:Expression) = Problem(MaximizationProblem, expr, Array[Constraint]())
}

sealed trait ProblemType
case object MinimizationProblem extends ProblemType
case object MaximizationProblem extends ProblemType
case object FeasibilityProblem extends ProblemType

sealed trait ProblemStatus
case object Solved extends ProblemStatus
case object Unbounded extends ProblemStatus
case object Unfeasible extends ProblemStatus

case class Solution[T](primal:Array[T], dual:Array[T], status:ProblemStatus, optval:T, has_dual:Boolean)