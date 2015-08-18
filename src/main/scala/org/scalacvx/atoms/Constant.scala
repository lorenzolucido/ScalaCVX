package org.scalacvx.atoms

import org.scalacvx.dcp._
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/18/15.
 */
case class Constant(value:SparseMatrix, override val sign:Sign) extends Expression {
  override val size: (Int,Int) = value.size
  override val length: Int = size._1 * size._2
  override val children = None

  def Constant(x:Double, checkSign:Boolean=true) = ???

  override val vexity: Vexity = ConstantVexity
  override val curvature = NotDcp // Should never reach here: a constant is not a function
  override val monotonicity:Monotonicity = ConstantMonotonicity // Should not be used ?
  override val evaluate = value


}
