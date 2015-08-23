package org.scalacvx.constraints

import org.scalacvx.conic.ConicObject


// This class encodes constraint such as x in K, K being a convex cone.
case class ConicConstraint(objects:Array[ConicObject], cone:ConeType, sizes:Array[Int])

sealed trait ConeType
case object ExponentialCone     extends ConeType
case object SemidefiniteCone    extends ConeType
case object SecondOrderCone     extends ConeType
case object NonNegativeOrthant  extends ConeType
case object ZeroCone            extends ConeType
