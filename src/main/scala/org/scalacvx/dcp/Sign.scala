package org.scalacvx.dcp

/**
 * Created by lorenzo on 8/16/15.
 */
trait Sign {

  def unary_- = this match {
    case Positive => Negative
    case Negative => Positive
    case _ => this
  }

  def +(that:Sign): Sign = (this, that) match {
    case (Positive, Positive) => Positive
    case (Negative, Negative) => Negative
    case (_,_) => NoSign
  }

  def -(that: Sign) = this + (-that)

  def *(that: Sign):Sign = (this, that) match {
    case (NoSign, _) => NoSign
    case (_, NoSign) => NoSign
    case (Positive, Positive) => Positive
    case (Negative, Negative) => Positive
    case (Positive, Negative) => Negative
    case (Negative, Positive) => Negative
    case (_, _) => NoSign
  }

  def *(that: Monotonicity): Monotonicity = (this, that) match {
    case (Positive, _) => that
    case (Negative, _) => -that
    case (_, _) => NoMonotonicity
  }

}

case object Positive extends Sign
case object Negative extends Sign
case object NoSign extends Sign