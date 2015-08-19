package org.scalacvx.atoms

import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/18/15.
 */
case class AbsAtom(childExpr:Expression) extends Expression {
  override val size: (Int, Int) = ???
  override val sign: Sign = Positive
  override val evaluate: SparseMatrix = ??? // Math.abs(childExpr.evaluate)
  override val curvature: Vexity = ConvexVexity
  override val monotonicity: Monotonicity = NonDecreasing * childExpr.sign
  override val children: Option[Array[Expression]] = Some(Array(childExpr))

  override val conicForm = ??? // ConicForm()
}
