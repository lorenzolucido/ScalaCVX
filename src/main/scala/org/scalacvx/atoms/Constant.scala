package org.scalacvx.atoms

import breeze.linalg.DenseMatrix
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/18/15.
 */
case class Constant(value:DenseMatrix[Double], override val sign:Sign) extends Expression {
  override val size: (Int,Int) = (value.rows, value.cols)
  //override val length: Int = size._1 * size._2
  override val children = None

  def Constant(x:Double, checkSign:Boolean=true) = ???

  override lazy val vexity: Vexity = ConstantVexity
  override val curvature = NotDcp // Should never reach here: a constant is not a function
  override val monotonicity:Monotonicity = NoMonotonicity // Should not be reached
  override val evaluate = value

  override lazy val conicForm = ConicForm(this, None)
}
