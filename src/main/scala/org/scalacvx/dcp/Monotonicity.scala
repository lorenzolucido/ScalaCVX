package org.scalacvx.dcp

/**
 * Created by lorenzo on 8/16/15.
 */
sealed trait Monotonicity {
  /*
  def unary_- = this match {
    case NonIncreasing => NonDecreasing
    case NonDecreasing => NonIncreasing
    case _ => this
  }

  def *(that:Sign): Monotonicity = that * this

  def *(that: Vexity): Vexity = (this, that) match {
    case (NonDecreasing, _) => that
    case (NonIncreasing, _) => -that
    case (NoMonotonicity, _) => that match {
      case ConvexVexity | ConcaveVexity => NotDcp
      case _ => that
    }
    case (_, _) => NotDcp
  }
  */

}

trait NegMon[M <: Monotonicity]

object NegMon {
  implicit def negNonInc[A <: NonIncreasing](a: NegMon[A]): NonDecreasing = ???
  implicit def negNonDec[A <: NonDecreasing](a: NegMon[A]): NonIncreasing = ???
}

trait NonIncreasing extends Monotonicity
trait NonDecreasing extends Monotonicity
trait ConstantMonotonicity extends Monotonicity
//case object NoMonotonicity extends Monotonicity


