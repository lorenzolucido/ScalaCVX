package org.scalacvx.atoms.affine

import breeze.linalg.DenseMatrix
import org.scalacvx.atoms.Expression
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/23/15.
 */
case class AddAtom[L <: Vexity, R <: Vexity, Out <: Vexity](lhs:Expression[L], rhs:Expression[R])
                                                           //(implicit ev: Add[L,R] => Out)
                                                            extends Expression[Out] {
  //require(lhs.size == rhs.size) // -> Transform to type-level check ?

  //override val size: (Int, Int) = lhs.size
  //override lazy val length: Int = lhs.length

  //override lazy val canonicalize:ConicForm = ???

  //override val children = ??? //Some(Array(ChildExpression(lhs, NonDecreasing),ChildExpression(rhs, NonDecreasing)))
  //override val sign: Sign = ??? //lhs.sign + rhs.sign
  //override lazy val evaluate: DenseMatrix[Double] = lhs.evaluate + rhs.evaluate
 // override val curvature: Vexity = ??? //ConstantVexity

  override def toString = lhs.toString + " + " + rhs.toString
}

object AddAtom {
  //implicit def toExpr[L <: Vexity, R <: Vexity, Out <: Vexity](addAtom: AddAtom[L,R,Out]): Expression[Out] = ???
}

