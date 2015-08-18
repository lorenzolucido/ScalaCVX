package org.scalacvx.atoms

import org.scalacvx.dcp._
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/18/15.
 */
case class AbsAtom(expr:Expression) extends Expression {
  override val size: (Int, Int) = ???
  override val sign: Sign = Positive
  override val evaluate: SparseMatrix = ???
  override val curvature: Vexity = ConvexVexity
  override val monotonicity: Monotonicity = NonDecreasing // * ... children ?
  override val children: Option[Array[Expression]] = ???
}
