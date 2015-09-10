package org.scalacvx.conic

import breeze.linalg.{DenseMatrix, DenseVector}
import org.scalacvx.atoms.Expression
import org.scalacvx.constraints.{ComparisonConstraint, ConeConstraint, Constraint}
import org.scalacvx.dcp.{ConstantVexity, AffineVexity}
//import org.scalacvx.atoms.Expression._
import org.scalacvx.conic.ConicForm._

/**
 * Conic Form (i.e. graph form of a convex optimization problem)
 *
 *    minimize    c'x
 *    subject to  Ax = b
 *                x in K
 *    (K being a convex cone - zero, free, positive orthant, second order, semidefinite, exponential)
 *
 * Epigraph conic form for expressions (from Madeleine Udell's ISMP slides):
 *
 *                    | x |
 *    minimize    C * | t | + d
 *    (over t)
 *                    | x |
 *    subject to  A * | t | + b in K  (K being a convex cone)
 */


case class ConicForm(objective:Expression, constraints:Array[ComparisonConstraint]=Array(), cones:Array[ConeConstraint]=Array()){

  val isObjectiveValid = objective.vexity == AffineVexity || objective.vexity == ConstantVexity
  //val areConstraintsValid =
  //  if(constraints.isEmpty) true
  //  else constraints.forall(c => c.vexity == AffineVexity || c.vexity == ConstantVexity)

  val isValid = isObjectiveValid //&& areConstraintsValid

  val canonicalize:ConicForm =
    if(isValid) this
    else objective.canonicalize //+ sum(constraints.map(c => c.expression.canonicalize):_*)
    // Sounds wrong: we lose the type of signed constraint by doing this.

  def +(that:ConicForm): ConicForm = ConicForm (
    this.objective + that.objective,
    this.constraints ++ that.constraints,
    this.cones ++ that.cones
  )

  def unary_- = ConicForm(- this.objective, this.constraints, this.cones)
  def -(that:ConicForm) = this + (-that)

}

object ConicForm {
  def sum(c:ConicForm*):ConicForm = if(c.size == 1) c(0) else c(0) + sum(c.drop(1):_*)
  //def sum(c:Seq[ConicForm]):ConicForm = sum(c:_*)
}

/*
 C:DenseMatrix[Double], d:DenseVector[Double],
 A:Array[DenseMatrix[Double]], b:Array[DenseVector[Double]], K:Array[ConeType]) {

 require(A.length > 0 && A.length == b.length && b.length == K.length)

 // ConicEpigraph function composition (f o g)
 def o(that: ConicForm) = ConicForm(
     C.t * horzcat(that.C, eye[Double](that.C.rows)),                // C_fog = Cf * [ Cg I ]
     C.t * that.d + d,                                               // d_fog = Cf * dg + df
     (A(0).t * horzcat(that.C, eye[Double](that.C.rows))) +: that.A, // A_fog = ...
     (A(0).t * that.d + b(0)) +: that.b,                             // b_fog = ... |
     K ++ that.K                                                     // K_fog = [Kf, Kg]
 )
 */


/*
case class ConicForm(objective: Expression, constraints:Option[Array[Constraint]]) {
  require(objective.vexity == AffineVexity)

  /*
  def unary_- = ConicForm(m map {case (i,sp) => (-1*i,sp)})

  def +(that:ConicForm):ConicForm = ???

  def getRow(row:Int) = ConicForm(m filter {case (i,sp) => i == row})

  def *(v:SparseMatrix) = ConicForm(m map {case (i, sp) => (i, sp * v)}) // * to be defined in SparseMatrix

  def promoteSize(vectorized_size:Int) = ???
  */

}


/*
case class ConicConstr(objs:Array[ConicForm], sizes:Array[Int])

object ConicForm {
  type UniqueExpMap = Map[(Int,Int), ConicForm] // Note: (Int,Int) is in fact (Symbol,Int) in Convex.jl
  type UniqueConstrMap = Map[(Int,Int), Int]
  type UniqueConstrList = Array[ConicConstr]
}

case class UniqueConicForms(exp_map:UniqueExpMap, constr_map:UniqueConstrMap, constr_list:UniqueConstrList)
*/

*/

