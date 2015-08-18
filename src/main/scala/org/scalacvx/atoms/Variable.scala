package org.scalacvx.atoms

import org.scalacvx.dcp.{Monotonicity, Vexity, Sign, NoSign}
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/16/15.
 */
case class Variable(size:(Int,Int), sign:Sign=NoSign) extends Expression {
  override val children = None
  override val monotonicity: Monotonicity = ???
  override val evaluate: SparseMatrix = ???
  override val curvature: Vexity = ???
}
