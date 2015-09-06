package org.scalacvx.constraints

import org.scalacvx.atoms.AffineExpression

/**
 *      - Second-order cone constraint -
 *
 *      This class takes an array of left-hand side affine expressions
 *      and one right-hand side affine expression.
 *      The constraint is defined as:
 *      ∀i, ||lhs(i)||_2 ≤ rhs
 */
case class SocConstraint(lhs:Array[AffineExpression], rhs:AffineExpression) {
  require(lhs.size >= 1)


}
