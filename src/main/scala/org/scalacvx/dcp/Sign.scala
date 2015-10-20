package org.scalacvx.dcp

import spire.algebra.Sign.Positive


/**
 * Created by lorenzo on 8/16/15.
 */
sealed trait Sign {
  /*
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
  */
}



object Sign {
  implicit def doubleToSign[S <: Sign](d: Double) = new Positive {}
}

trait AddSign[S <: Sign, T <: Sign]

object AddSign {
  implicit def pos[A <: Positive, B <: Positive](x: AddSign[A, B]): Positive = ???
  implicit def neg[A <: Negative, B <: Negative](x: AddSign[A, B]): Negative = ???
}

trait NegSign[S <: Sign]

object NegSign {
  implicit def negPos[A <: Positive](x: NegSign[A]): Negative = ???
  implicit def negNeg[A <: Negative](x: NegSign[A]): Positive = ???
}

trait MultSign[S <: Sign, T <: Sign]

object MultSign {
  implicit def m_PosPos[A <: Positive, B <: Positive](x: AddSign[A, B]): Positive = ???
  implicit def m_NegNeg[A <: Negative, B <: Negative](x: AddSign[A, B]): Positive = ???
  implicit def m_PosNeg[A <: Positive, B <: Negative](x: AddSign[A, B]): Negative = ???
  implicit def m_NegPos[A <: Negative, B <: Positive](x: AddSign[A, B]): Negative = ???
}

trait MultSignMon[S <: Sign, M <: Monotonicity]

object MultSignMon {
  implicit def m_Pos[S <: Positive, M <: Monotonicity](x: MultSignMon[S, M]): M = ???
  implicit def m_Neg[S <: Negative, M <: Monotonicity, Out <: Monotonicity](x: MultSignMon[S, M])
                                                                 (implicit ev:  NegMon[M] =:= Out): Out = ???
}

//trait UnknownSign extends Sign
trait Positive extends Sign
trait Negative extends Sign