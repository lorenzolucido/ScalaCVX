package org.scalacvx.constraints

import org.scalacvx.atoms.Expression
import org.scalacvx.dcp.AffineVexity

/**
 * Created by lorenzo on 9/10/15.
 */
trait ConeConstraint extends Constraint


/**
 *      - Second-order cone constraint -
 *
 *      This class takes an array of left-hand side affine expressions
 *      and one right-hand side affine expression.
 *      The constraint is defined as:
 *      ∀i, ||lhs(i)||_2 ≤ rhs
 */
case class SocConstraint(lhs:Array[Expression], rhs:Expression) {
  require(lhs.size >= 1)
  require((lhs:+rhs).forall(e => e.vexity.isInstanceOf[AffineVexity]), "SoC constraint: all expressions must be affine.")
}


/**
 *      - Semi-definite positive cone constraint -
 *
 *
 */
class SdpConstraint extends ConeConstraint