package org.scalacvx.dcp

/**
 * Created by lorenzo on 8/16/15.
 */
sealed trait Vexity {

  def unary_- = this match {
    case ConvexVexity => ConcaveVexity
    case ConcaveVexity => ConvexVexity
    case _ => this
  }

  def +(that:Vexity): Vexity = (this, that) match {
    case (ConstantVexity, _) => that
    case (_, ConstantVexity) => this
    case (AffineVexity, _) => that
    case (_, AffineVexity) => this
    case (ConvexVexity, ConvexVexity) => ConvexVexity
    case (ConcaveVexity, ConcaveVexity) => ConcaveVexity
    case (_, _) => NotDcp
  }

  def -(that: Vexity) = this + (-that)

}

trait ConvexVexity extends Vexity
case object ConvexVexity extends ConvexVexity

trait ConcaveVexity extends Vexity
case object ConcaveVexity extends ConcaveVexity

trait AffineVexity extends ConvexVexity with ConcaveVexity
case object AffineVexity extends AffineVexity

trait ConstantVexity extends AffineVexity
case object ConstantVexity extends ConstantVexity

case object NotDcp extends Vexity

