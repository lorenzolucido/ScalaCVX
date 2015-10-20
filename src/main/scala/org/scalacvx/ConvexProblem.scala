package org.scalacvx

import org.scalacvx.atoms.Expression
import org.scalacvx.conic.ConicForm
import org.scalacvx.constraints.{ComparisonConstraint, ConeConstraint, Constraint}


case class ConvexProblem() {//objective: Expression[_], constraints:Array[ComparisonConstraint] = Array[ComparisonConstraint]()) {
  /*
  // In Convex.jl, the problem class contains the solution. Can we do better ?
  require(objective.vexity.isInstanceOf[ConvexVexity], "Objective should be convex for min problems and concave for max problems.")


  // The conic form functon converts the current problem into an equivalent one
  // with linear function as objective subject to comparison and/or cone constraints
  lazy val conicForm:ConicForm = ??? // ConicForm(objective, constraints)


  def subjectTo(const:ComparisonConstraint) = ConvexProblem(objective, constraints :+ const)
  def subjectTo(consts:Array[ComparisonConstraint]) = ConvexProblem(objective, constraints ++ consts)
  */
}

object ConvexProblem {
  /*
  def minimize(expr:Expression) = ConvexProblem(expr, Array[ComparisonConstraint]())
  def maximize(expr:Expression) = ConvexProblem(-expr, Array[ComparisonConstraint]())
  */
}

/*
sealed trait ProblemStatus
case object Solved extends ProblemStatus
case object Unbounded extends ProblemStatus
case object Unfeasible extends ProblemStatus

case class Solution[T](primal:Array[T], dual:Array[T], status:ProblemStatus, optval:T, has_dual:Boolean)
*/