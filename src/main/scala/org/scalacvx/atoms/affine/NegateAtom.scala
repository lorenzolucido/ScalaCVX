package org.scalacvx.atoms.affine

import org.scalacvx.atoms.Expression
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/23/15.
 */
case class NegateAtom[V <: Vexity, Out <: Vexity](expr:Expression[V]) extends Expression[Out] {

  //override lazy val length: Int = expr.length
  //override lazy val canonicalize = ???
  //override val size: (Int, Int) = expr.size
  //override val children = ??? //Some(Array(ChildExpression(expr, NonIncreasing)))
  //override val sign: Sign = ??? //- expr.sign
  //override lazy val evaluate = - expr.evaluate
  //override val curvature: Vexity = ??? //ConstantVexity

  override def toString = "-" + expr.toString
}

object NegateAtom {
  //def apply[V <: Vexity, Out0 <: Vexity, Out1 <: Vexity](expr: Expression[V])
  //                                            (implicit ev0:  V **: NonIncreasing => Out0,
  //                                                     ev1: ConstantVex ++: Out0 => Out1): NegateAtom[V, Out0, Out1 ]
  //                                            = NegateAtom(expr)
  //implicit def toExpr[V <: Vexity, Out <: Vexity](negAtom: NegateAtom[V,Out]): Expression[Out] = ???
}

