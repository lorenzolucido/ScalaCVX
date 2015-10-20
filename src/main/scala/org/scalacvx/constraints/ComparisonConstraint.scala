package org.scalacvx.constraints

import org.scalacvx.atoms.Expression

/**
 * Created by lorenzo on 9/10/15.
 */
trait ComparisonConstraint extends Constraint {
  //require(lhs.size == rhs.size,
  //  s"Cannot create equality constraint between expressions of size ${lhs.size} and ${rhs.size}")

  //val lhs: Expression
  //val rhs: Expression
}

/*
case class EqualityConstraint(lhs:Expression, rhs:Expression) extends ComparisonConstraint {

  //require(List(lhs,rhs).forall(e => e.vexity.isInstanceOf[AffineVexity]),
  //  s"Cannot create equality constraint: ${lhs.vexity} == ${rhs.vexity} (must be AffineVexity == AffineVexity")

  /*
  override val expression = lhs - rhs

  override val vexity = lhs.vexity - rhs.vexity match {
      case ConvexVexity | ConcaveVexity => NotDcp
      case _ => lhs.vexity - rhs.vexity
    }
  */
  //override lazy val conicForm = ConicForm()
}

case class LtConstraint(lhs:Expression, rhs:Expression) extends ComparisonConstraint {
  //require(lhs.vexity.isInstanceOf[ConvexVexity] && rhs.vexity.isInstanceOf[ConcaveVexity],
  //  s"Cannot create inequality constraint: ${lhs.vexity} < ${rhs.vexity} (must be ConvexVexity < ConcaveVexity")
}

case class GtConstraint(lhs:Expression, rhs:Expression) extends ComparisonConstraint {
  //require(lhs.vexity.isInstanceOf[ConcaveVexity] && rhs.vexity.isInstanceOf[ConvexVexity],
  //  s"Cannot create inequality constraint: ${lhs.vexity} > ${rhs.vexity} (must be ConcaveVexity > ConvexVexity")
}
*/