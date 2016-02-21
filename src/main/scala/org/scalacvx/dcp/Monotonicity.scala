package org.scalacvx.dcp


/**
 * Created by lorenzo on 8/16/15.
 */
sealed trait Monotonicity

trait NegMon[M <: Monotonicity]

object NegMon {
  implicit def negNonInc[A <: NonIncreasing](a: NegMon[A]): NonDecreasing = ???
  implicit def negNonDec[A <: NonDecreasing](a: NegMon[A]): NonIncreasing = ???
}

// Trait **:
// Multiplies a Vexity by a Monotonicity
trait **:[V <: Vexity, M <: Monotonicity]

object **: {

  implicit def multConcNonInc[V <: Concave, M <: NonIncreasing](a: V **: M) : Convex = ???
  implicit def multConvNonInc[V <: Convex, M <: NonIncreasing](a: V **: M) : Concave = ???
  implicit def multConcNonDec[V <: Concave, M <: NonDecreasing](a: V **: M) : Concave = ???
  implicit def multConvNonDec[V <: Convex, M <: NonDecreasing](a: V **: M) : Convex = ???

  implicit def multAffNonMon[V <: Affine, M <: NonMonotonic](a: V **: M) : V = ???
  implicit def multAffNonInc[V <: Affine, M <: NonIncreasing](a: V **: M) : V = ???
  implicit def multAffNonDec[V <: Affine, M <: NonDecreasing](a: V **: M) : V = ???
  //implicit def multNonMon[V <: Affine, M <: Monotonicity](a: V **: M): V = ???
}

trait NonMonotonic extends Monotonicity
trait NonIncreasing extends Monotonicity
trait NonDecreasing extends Monotonicity
//trait ConstantMonotonicity extends Monotonicity
//case object NoMonotonicity extends Monotonicity


