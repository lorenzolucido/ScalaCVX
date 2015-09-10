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

  override lazy val canonicalize:ConicForm = ???

  override val children = Some(Array(ChildExpression(lhs, NonDecreasing),ChildExpression(rhs, NonDecreasing)))
  override val sign: Sign = lhs.sign + rhs.sign
  override lazy val evaluate: DenseMatrix[Double] = lhs.evaluate + rhs.evaluate
  override val curvature: Vexity = ConstantVexity

  override def toString = lhs.toString + " + " + rhs.toString
}

