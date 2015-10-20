package org.scalacvx.atoms

import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/18/15.
 */
case class Constant[S <: Sign](value:Double)(implicit toSign: Double => S) extends Expression[ConstantVex] {
  val vars = List()
  val const = this // Can we do better here ?

  //override val size: (Int,Int) = (value.rows, value.cols)

  //override val children = None

  //def Constant(x:Double, checkSign:Boolean=true) = ???

  //override lazy val vexity: Vexity = ConstantVexity
  //override val curvature = NotDcp // Should never reach here: a constant is not a function

  //override lazy val evaluate = value

  //override def unary_-():Constant = Constant(-value)
  //def +(that:Constant):Constant = Constant(value + that.value)

  //override lazy val canonicalize = ??? //ConicForm(this)
}


/*
object Constant{
  def apply(num:Double):Constant = Constant(DenseMatrix(num))
}
*/