package org.scalacvx.atoms.affine

import org.scalacvx.atoms.Expression
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/23/15.
 */
case class NegateAtom[V <: Vexity, Out <: Vexity](expr:Expression[V])
                                                 //(implicit ev: Neg[V] => Out)
                                          extends Expression[Out] {

  override lazy val length: Int = expr.length
  //override lazy val canonicalize = ???
  override val size: (Int, Int) = expr.size
  override val children = ??? //Some(Array(ChildExpression(expr, NonIncreasing)))
  override val sign: Sign = ??? //- expr.sign
  //override lazy val evaluate = - expr.evaluate
  override val curvature: Vexity = ??? //ConstantVexity

  override def toString = "-" + expr.toString
}

object NegateAtom {
  implicit def toExpr[V <: Vexity, Out <: Vexity](negAtom: NegateAtom[V,Out]): Expression[Out] = ???
}

