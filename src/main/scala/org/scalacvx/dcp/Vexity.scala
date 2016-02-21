package org.scalacvx.dcp

sealed trait Vexity

trait ++:[V <: Vexity, W <: Vexity]

object ++: {

  implicit def const[A <: ConstantVex, B <: ConstantVex](x: ++:[A, B]): ConstantVex = ???
  implicit def aff[A <: Affine, B <: Affine](x: ++:[A, B]): Affine = ???
  implicit def conc[A <: Concave, B <: Concave](x: ++:[A, B]): Concave = ???
  implicit def conv[A <: Convex, B <: Convex](x: ++:[A, B]): Convex = ???


}

sealed trait Convex extends Vexity

sealed trait Concave extends Vexity

sealed trait Affine extends Convex with Concave

sealed trait ConstantVex extends Affine
