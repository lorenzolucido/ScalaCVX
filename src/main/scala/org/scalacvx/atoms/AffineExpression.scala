package org.scalacvx.atoms

import breeze.linalg.DenseMatrix
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp.{NoSign, AffineVexity, Sign, Vexity}

/**
 * Affine expressions are a particular type of expressions.
 * TBD: Show that (AffineExpression, +, *) is a ring.
 */
abstract class AffineExpressionAbstract extends Expression {
  val vars:List[(Constant,Variable)]
  val const:Constant

  require(vars.forall(cv => cv._1.size == cv._2.size) && vars.forall(cv => cv._1.size == const.size), "Affine expression: sizes do no match")

  override val size: (Int, Int) = const.size
  override val children: Option[Array[ChildExpression]] = None
  override lazy val canonicalize: ConicForm = ConicForm(this)
  override val sign: Sign = NoSign
  override lazy val evaluate: DenseMatrix[Double] = ???
  override val curvature: Vexity = AffineVexity

  override def unary_-():AffineExpressionAbstract = AffineExpression(vars.map{ case (c,v) => (-c, v)},-const)

  def +(that:AffineExpressionAbstract):AffineExpressionAbstract = AffineExpression(this.vars ++ that.vars, const + that.const)
  // This is wrong !!!! (what if there are twice the same variable ?)

  require(vars.forall(cv => cv._1.size == cv._2.size) && vars.forall(cv => cv._1.size == const.size), "Affine expression: sizes do no match")
  //
}

case class AffineExpression(vars:List[(Constant,Variable)], const:Constant) extends AffineExpressionAbstract {
  //require(vars.map(_._2).forall(_.size == (1,1)), "Affine expression should take only single variables")


}
