package org.scalacvx.structures


/**
 * Created by lorenzo on 8/18/15.
 */
case class SparseMatrix(values:Array[Double], locations:Array[(Int,Int)], size:(Int,Int)) {

  def this(value:Double) = this(Array(value), Array((1,1)), (1,1))
  def this(values:Array[Double]) = this(values, values.indices map((_,1)) toArray , (values.length,1))

  def *(that:SparseMatrix) = ???
}

