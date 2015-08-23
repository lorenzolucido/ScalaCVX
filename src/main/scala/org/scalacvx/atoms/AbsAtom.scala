package org.scalacvx.atoms

import breeze.linalg.DenseMatrix
import breeze.numerics.abs
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/18/15.
 */
case class AbsAtom(expr:Expression) extends Expression {
  override val size: (Int, Int) = expr.size
  override val sign: Sign = Positive
  override lazy val evaluate: DenseMatrix[Double] = abs(expr.evaluate)
  override val curvature: Vexity = ConvexVexity
  override val monotonicity: Monotonicity = NonDecreasing * expr.sign
  override val children: Option[Array[Expression]] = Some(Array(expr))

  //override val conicForm = ??? // ConicForm()


}
