package org.scalacvx.atoms

import breeze.linalg.DenseMatrix
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._
import org.scalacvx.atoms.ExpressionImplicits._
import scala.util.Random

/**
 * Created by lorenzo on 8/16/15.
 */
case class Variable(sizeVar:(Int,Int)=(1,1), name:String) extends AffineExpressionAbstract {

  override val sign:Sign=NoSign
  override val size = sizeVar
  lazy val value:Option[DenseMatrix[Double]]=None

  lazy val vars = List((Constant(DenseMatrix.ones[Double](size._1,size._2)),this)) // this: Can we do better here ?
  lazy val const = Constant(DenseMatrix.zeros[Double](size._1,size._2))


}


object Variable {

  def apply(rows: Int, cols: Int):Variable = Variable((rows, cols), Random.alphanumeric.take(10).mkString(""))
  def apply(rows: Int):Variable = Variable((rows, 1), Random.alphanumeric.take(10).mkString(""))
  def apply():Variable = Variable((1,1), Random.alphanumeric.take(10).mkString(""))
}