package org.scalacvx.atoms.affine

import breeze.linalg.DenseMatrix
import org.scalacvx.atoms.Expression
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/23/15.
 */
case class AddAtom(lhs:Expression, rhs:Expression) extends Expression {
  require(lhs.size == rhs.size)

  override val size: (Int, Int) = lhs.size
  override lazy val length: Int = lhs.length

  override lazy val conicForm: ConicForm = ???

  override val children: Option[Array[Expression]] = Some(Array(lhs, rhs))
  override val sign: Sign = lhs.sign + rhs.sign
  override lazy val evaluate: DenseMatrix[Double] = lhs.evaluate + rhs.evaluate
  override val curvature: Vexity = ConstantVexity
  override val monotonicity: Monotonicity = NonDecreasing // This is not right, there should be as many Monotonicities as children



}
