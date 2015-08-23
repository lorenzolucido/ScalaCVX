package org.scalacvx.atoms.affine

import org.scalacvx.atoms.Expression
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/23/15.
 */
case class NegateAtom(expr:Expression) extends Expression {

  override lazy val length: Int = expr.length
  override lazy val conicForm: ConicForm = ???
  override val size: (Int, Int) = expr.size
  override val children: Option[Array[Expression]] = Some(Array(expr))
  override val sign: Sign = - expr.sign
  override lazy val evaluate = - expr.evaluate
  override val curvature: Vexity = ConstantVexity
  override val monotonicity: Monotonicity = NonIncreasing


}

