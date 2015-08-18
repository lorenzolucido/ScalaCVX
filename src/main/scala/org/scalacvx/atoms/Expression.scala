package org.scalacvx.atoms

import org.scalacvx.dcp.{ConstantVexity, Monotonicity, Sign, Vexity}
import org.scalacvx.structures.SparseMatrix

/**
 * Created by lorenzo on 8/16/15.
 */
trait Expression {

  val size: (Int, Int)
  val length = size._1 * size._2
  val children:Option[Array[Expression]]

  val monotonicity: Monotonicity

  val curvature: Vexity
  val evaluate: SparseMatrix
  val sign: Sign

  val vexity:Vexity = ??? //if(children.isDefined) children.get.foldLeft[Vexity](curvature){(a:Vexity,b:Vexity) => a + b} else curvature

}
