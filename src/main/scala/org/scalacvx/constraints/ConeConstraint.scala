package org.scalacvx.constraints

import org.scalacvx.atoms.Expression

/**
 * Created by lorenzo on 9/10/15.
 */
trait ConeConstraint extends Constraint {
  /*
  require(lhs.forall(e => e.vexity.isInstanceOf[AffineVexity]), "All expressions must be affine in a cone constraint")
  val lhs:Array[Expression]
  */
}
/*
/**     - Zero cone constraint -
 *
 *      Equivalent to Ax + b = 0
 */
case class ZeroConeConstraint(lhs:Array[Expression]) extends ConeConstraint

/**     - Non-negative orthant cone constraint -
  *
  *      Equivalent to Ax + b > 0
  */
case class NonNegativeOrthantConeConstraint(lhs:Array[Expression]) extends ConeConstraint

/**
 *      - Second-order cone constraint -
 *
 *      This class takes an array of left-hand side affine expressions
 *      and one right-hand side affine expression.
 *      The constraint is defined as:
 *      ∀i, ||lhs(i)||_2 ≤ rhs
 */
case class SocConstraint(lhs:Array[Expression], rhs:Expression) extends ConeConstraint {
  /*
  require(lhs.size >= 1)
  require(rhs.vexity.isInstanceOf[AffineVexity], "SoC constraint: rhs must be affine.")
  */
}


/**
 *      - Semi-definite positive cone constraint -
 *
 *
 */
case class SdpConeConstraint(lhs:Array[Expression]) extends ConeConstraint
*/