package org.scalacvx.atoms

import org.scalacvx.atoms.affine.{AddAtom, NegateAtom}
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/16/15.
 */
trait Expression[V <: Vexity] {

  case class ChildExpression[C <: Vexity](expr: Expression[C], mon: Monotonicity)

  //val size: (Int, Int) = ???
  //val children: Option[Array[ChildExpression]] //= ???

  //val evaluate: DenseMatrix[Double] = ???
  //val sign: Sign = ???

  //val canonicalize: ConicForm = ???
  //val curvature: Vexity = ???

  //lazy val length = size._1 * size._2
  //lazy val vexity: Vexity =
  //  if (children.isDefined) children.get.foldLeft[Vexity](curvature) { (v, e) => v + e.mon * e.expr.vexity } else curvature

  //lazy val conicForm: ConicForm = ???
    //if (children.isDefined) children.get.foldLeft[ConicForm](canonicalize) { (v, e) => v + e.expr.conicForm } else canonicalize

  // Constraints
  /*
  def ==(that: Expression) = EqualityConstraint(this, that)

  def <=(that: Expression) = LtConstraint(this, that)

  def ≤(that: Expression) = this <= that

  def <(that: Expression) = LtConstraint(this, that)

  def >(that: Expression) = GtConstraint(this, that)

  def >=(that: Expression) = GtConstraint(this, that)

  def ≥(that: Expression) = this >= that
  */

  // Implemented atoms -- 1 --
  def unary_-[Out0 <: Vexity]
      (implicit ev0: V **: NonIncreasing => Out0): NegateAtom[V, Out0]
                  = NegateAtom[V, Out0](this)

  def +[W <: Vexity, Out0 <: Vexity, Out1 <: Vexity, Out2 <: Vexity](that: Expression[W])
  (implicit  ev0: V **: NonDecreasing => Out0,
             ev1: W **: NonDecreasing => Out1,
             ev2: Out0 ++: Out1 => Out2): AddAtom[V, W, Out2]
                                 //  : Expression[Out]
                                    = AddAtom[V, W, Out2](this, that)

  def -[W <: Vexity, Out0 <: Vexity, Out1 <: Vexity, Out2 <: Vexity, Out3 <: Vexity](that: Expression[W])
    (implicit ev:  V **: NonDecreasing => Out0,
              ev0: W **: NonIncreasing => Out1,
              ev1: Out1 **: NonDecreasing => Out2,
              ev2: Out0 ++: Out2 => Out3): AddAtom[V, Out1, Out3]
              = this. +(that.unary_-[Out1])
}


object ExpressionImplicits {
  // Implemented atoms -- 2 --
  def abs[V <: Vexity, Out <: Vexity](expr: Expression[V])
                                     (implicit ev: V **: AbsAtom[_,_]#M => Out):Expression[Out]
            = AbsAtom(expr)

  //def sum(exprs: Expression*): Expression = if (exprs.size == 1) exprs(0) else exprs(0) + sum(exprs.drop(1): _*)

  //def sum(lexp:Seq[Expression]):Expression = sum(lexp:_*)

  //implicit def numToConstant(value: Double) = Constant(DenseMatrix(value), NoSign) // Must be generalized to Numeric types
}
