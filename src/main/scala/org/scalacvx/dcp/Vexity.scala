package org.scalacvx.dcp

/**
 * Created by lorenzo on 8/16/15.
 */
sealed trait Vexity

trait ++:[V <: Vexity, W <: Vexity] //{ type Apply <: Vexity }

object ++: {
  implicit def conc[A <: Concave, B <: Concave](x: ++:[A, B]): Concave = ???
  implicit def conv[A <: Convex, B <: Convex](x: ++:[A, B]): Convex = ???
  implicit def aff[A <: Affine, B <: Affine](x: ++:[A, B]): Affine = ???
  implicit def const[A <: ConstantVex, B <: ConstantVex](x: ++:[A, B]): ConstantVex = ???
}

trait Neg[V <: Vexity]

object Neg {
  implicit def negConcave[A <: Concave](x: Neg[A]): Convex = ???
  implicit def negConvex[A <: Convex](x: Neg[A]): Concave = ???
  implicit def negAffine[A <: Affine](x: Neg[A]): Affine = ???
  implicit def negConstant[A <: ConstantVex](x: Neg[A]): ConstantVex = ???
}

sealed trait Convex extends Vexity

sealed trait Concave extends Vexity

sealed trait Affine extends Convex with Concave

sealed trait ConstantVex extends Affine

//trait MyConcave extends Vexity { override type Neg = MyConvex}
//trait MyConvex extends Vexity { override type Neg = MyConcave }
//trait MyAffine extends MyConcave with MyConvex { override type Neg = MyAffine }