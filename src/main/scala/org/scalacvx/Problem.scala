package org.scalacvx

import org.scalacvx.atoms.Expression
import org.scalacvx.constraints.Constraint
import org.scalacvx.dcp.{ConstantVexity, Vexity}


trait Problem {
  val problemType: ProblemType
  val objective: Expression
  val constraints: Iterable[Constraint]

  def status:ProblemStatus = this.solution.status
  def optval = this.solution.optval
  def model = ???
  def solution: Solution[Float] = ???

  def vexity:Vexity = {
    val objectiveVex = if(problemType == MinimizationProblem) objective.vexity else -objective.vexity
    val constraintVex = constraints.map(c => c.vexity).foldLeft[Vexity](ConstantVexity) {(a, b) => a + b }

    // Todo: Need to check if this is convex
    objectiveVex + constraintVex
  }

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