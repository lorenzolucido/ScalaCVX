package org.scalacvx.atoms

import org.scalacvx.dcp._
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/16/15.
 */
case class Variable(size:(Int,Int), sign:Sign=NoSign, value:Option[SparseMatrix]=None) extends Expression {
  override val children = None
  override val monotonicity: Monotonicity = ???
  override val evaluate: SparseMatrix =
    if(value.isDefined) value.get else throw new NoSuchElementException("Value yet to be calculated")
  override val curvature: Vexity = AffineVexity

  override val conicForm = ???
}
