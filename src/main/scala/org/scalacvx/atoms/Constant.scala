package org.scalacvx.atoms

import breeze.linalg.DenseMatrix
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._

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

  override val evaluate = value

  override lazy val canonicalize = ConicForm(this)
}

object Constant {
  def apply(const: Double):Constant = Constant(DenseMatrix((const)), NoSign)
}
