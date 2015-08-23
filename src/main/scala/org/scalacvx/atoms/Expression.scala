package org.scalacvx.atoms

import breeze.linalg.DenseMatrix
import org.scalacvx.atoms.affine.{AddAtom, NegateAtom}
import org.scalacvx.conic.{ConicEpigraphForm, ConicForm}
import org.scalacvx.constraints.{GtConstraint, LtConstraint, EqualityConstraint}
import org.scalacvx.dcp._
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/16/15.
 */
trait Expression {

  case class ChildExpression(expr: Expression, mon:Monotonicity)

  val size: (Int, Int)
  val children:Option[Array[ChildExpression]]
  //val monotonicity: Monotonicity
  val curvature: Vexity
  val evaluate: DenseMatrix[Double]
  val sign: Sign

  lazy val length = size._1 * size._2
  lazy val vexity:Vexity =
    if (children.isDefined) children.get.foldLeft[Vexity](curvature) { (v, e) => v + e.expr.vexity } else curvature

  //val graphRepr:ConicEpigraphForm

  lazy val conicForm: ConicForm = ??? // if (graphRepr == this) this else graphRepr o children.get(0).graphRepr

  // Constraints
  def ==(that:Expression) = EqualityConstraint(this, that)
  def <=(that:Expression) = LtConstraint(this, that)
  def <(that:Expression) = LtConstraint(this, that)
  def >(that:Expression) = GtConstraint(this, that)
  def >=(that:Expression) = GtConstraint(this, that)

  // Implemented atoms
  def unary_- = NegateAtom(this)
  def +(that:Expression) = AddAtom(this, that)
  def -(that:Expression) = AddAtom(this, -that)

}

object Expression {
  def abs(expr:Expression) = AbsAtom(expr)
}