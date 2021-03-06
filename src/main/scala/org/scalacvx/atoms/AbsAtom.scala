package org.scalacvx.atoms

import breeze.linalg.DenseMatrix
import breeze.numerics.abs
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/18/15.
 */
case class AbsAtom(expr:Expression) extends Expression {
  override val size: (Int, Int) = expr.size
  override val sign: Sign = Positive
  override lazy val evaluate: DenseMatrix[Double] = abs(expr.evaluate)
  override val curvature: Vexity = ConvexVexity
  override val children = Some(Array(ChildExpression(expr, NonDecreasing * expr.sign)))

  override lazy val canonicalize = ???

  override def toString = "|" + expr.toString + "|"
}
