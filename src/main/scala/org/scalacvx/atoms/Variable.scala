package org.scalacvx.atoms

import breeze.linalg.DenseMatrix
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/16/15.
 */
case class Variable(size:(Int,Int), sign:Sign=NoSign, value:Option[DenseMatrix[Double]]=None) extends Expression {

  override val children = None
  override val curvature: Vexity = AffineVexity

  override val monotonicity: Monotonicity = NoMonotonicity

  override lazy val evaluate: DenseMatrix[Double] =
    if(value.isDefined) value.get else throw new NoSuchElementException("Value yet to be calculated")


  override lazy val conicForm = ConicForm(this, None)
}


object Variable {
  def apply(rows: Int, cols: Int):Variable = Variable((rows, cols))
  def apply(rows: Int):Variable = Variable((rows, 1))
  def apply():Variable = Variable((1,1))
}