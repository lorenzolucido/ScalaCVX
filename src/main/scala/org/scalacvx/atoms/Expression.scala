package org.scalacvx.atoms

import breeze.linalg.DenseMatrix
import org.scalacvx.atoms.ExpressionImplicits._
import org.scalacvx.atoms.affine.{AddAtom, NegateAtom}
import org.scalacvx.conic.ConicForm
import org.scalacvx.constraints.{GtConstraint, LtConstraint, EqualityConstraint}
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/16/15.
 */
trait Expression {

  case class ChildExpression(expr: Expression, mon:Monotonicity)

  val size: (Int, Int)
  val children:Option[Array[ChildExpression]]

  val evaluate: DenseMatrix[Double]
  val sign: Sign

  val canonicalize:ConicForm
  val curvature: Vexity

  lazy val length = size._1 * size._2
  lazy val vexity:Vexity =
    if (children.isDefined) children.get.foldLeft[Vexity](curvature) { (v, e) => v + e.mon * e.expr.vexity } else curvature

  lazy val conicForm: ConicForm =
    if (children.isDefined) children.get.foldLeft[ConicForm](canonicalize) { (v, e) => v + e.expr.conicForm } else canonicalize

  // Constraints
  def ==(that:Expression) = EqualityConstraint(this, that)
  def <=(that:Expression) = LtConstraint(this, that)
  def ≤(that:Expression) = this <= that
  def <(that:Expression) = LtConstraint(this, that)
  def >(that:Expression) = GtConstraint(this, that)
  def >=(that:Expression) = GtConstraint(this, that)
  def ≥(that:Expression) = this >= that

  // Implemented atoms
  def unary_-():Expression = NegateAtom(this)
  def +(that:Expression):Expression = AddAtom(this, that)
  def -(that:Expression):Expression = this + (-that)

}

object ExpressionImplicits {
  def abs(expr:Expression) = AbsAtom(expr)
  def sum(exprs:Expression*):Expression = if(exprs.size == 1) exprs(0) else exprs(0) + sum(exprs.drop(1):_*)
  //def sum(lexp:Seq[Expression]):Expression = sum(lexp:_*)

  implicit def numToConstant(value:Double) = Constant(DenseMatrix(value), NoSign) // Must be generalized to Numeric types
}

