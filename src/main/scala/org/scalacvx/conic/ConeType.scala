package org.scalacvx.conic

/**
 * Created by lorenzo on 8/23/15.
 */
sealed trait ConeType
case object ExponentialCone     extends ConeType
case object SemidefiniteCone    extends ConeType
case object SecondOrderCone     extends ConeType
case object NonNegativeOrthant  extends ConeType
case object ZeroCone            extends ConeType
