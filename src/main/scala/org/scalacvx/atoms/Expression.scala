package org.scalacvx.atoms

import breeze.linalg.DenseMatrix
import org.scalacvx.atoms.affine.{NegateAtom, AddAtom}
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/16/15.
 */
trait Expression[V <: Vexity] {

  case class ChildExpression[C <: Vexity](expr: Expression[C], mon: Monotonicity)

  val size: (Int, Int) = ???
  val children: Option[Array[ChildExpression[_]]] = ???

  val evaluate: DenseMatrix[Double] = ???
  val sign: Sign = ???

  val canonicalize: ConicForm = ???
  val curvature: Vexity = ???

  lazy val length = size._1 * size._2
  //lazy val vexity: Vexity =
  //  if (children.isDefined) children.get.foldLeft[Vexity](curvature) { (v, e) => v + e.mon * e.expr.vexity } else curvature

  lazy val conicForm: ConicForm = ???
    //if (children.isDefined) children.get.foldLeft[ConicForm](canonicalize) { (v, e) => v + e.expr.conicForm } else canonicalize

  // Constraints
  /*
  def ==(that: Expression) = EqualityConstraint(this, that)

  def <=(that: Expression) = LtConstraint(this, that)

  def ≤(that: Expression) = this <= that

  def <(that: Expression) = LtConstraint(this, that)

  def >(that: Expression) = GtConstraint(this, that)

  def >=(that: Expression) = GtConstraint(this, that)

  def ≥(that: Expression) = this >= that
  */

  // Implemented atoms
  def unary_-[Out <: Vexity](implicit ev: Neg[V] => Out) : Expression[Out] = NegateAtom(this)

  def +[W <: Vexity, Out <: Vexity](that: Expression[W])
                                   (implicit ev: Add[V,W] => Out)
                                   : Expression[Out]
                                    = AddAtom(this, that)

  def -[W <: Vexity, NegW <: Vexity, Out <: Vexity](that: Expression[W])(
    implicit  ev0: Neg[W] => NegW,
              ev1: Add[V, NegW] => Out): Expression[Out]
              = this + (-that)

}


object ExpressionImplicits {
  def abs[V <: Convex, Out <: Vexity](expr: Expression[V])
                                     (implicit ev: MultVexMon[V,AbsAtom[_,_]#M] =:= Out):Expression[Out] = AbsAtom(expr)

  //def sum(exprs: Expression*): Expression = if (exprs.size == 1) exprs(0) else exprs(0) + sum(exprs.drop(1): _*)

  //def sum(lexp:Seq[Expression]):Expression = sum(lexp:_*)

  //implicit def numToConstant(value: Double) = Constant(DenseMatrix(value), NoSign) // Must be generalized to Numeric types
}
