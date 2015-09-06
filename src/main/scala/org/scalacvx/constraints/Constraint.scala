package org.scalacvx.constraints

import org.scalacvx.atoms.{Expression}
import org.scalacvx.conic.{ConeType, ConicForm}
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/16/15.
 */
sealed trait Constraint {
  //val conicForm:ConicForm
}

trait SignedConstraint extends Constraint {
  val lhs: Expression
  val rhs: Expression
  val vexity:Vexity
  val expression:Expression
}

case class EqualityConstraint(lhs:Expression, rhs:Expression) extends SignedConstraint {
  require(lhs.size == rhs.size,
    s"Cannot create equality constraint between expressions of size ${lhs.size} and ${rhs.size}")

  override val expression = lhs - rhs

  override val vexity = lhs.vexity - rhs.vexity match {
      case ConvexVexity | ConcaveVexity => NotDcp
      case _ => lhs.vexity - rhs.vexity
    }

  //override lazy val conicForm = ConicForm()
}

case class LtConstraint(lhs:Expression, rhs:Expression) extends SignedConstraint {
  require(lhs.size == rhs.size,
    s"Cannot create inequality constraint between expressions of size ${lhs.size} and ${rhs.size}")

  override val expression = rhs - lhs

  override val vexity = lhs.vexity - rhs.vexity match {
    case ConcaveVexity => NotDcp
    case _ => lhs.vexity - rhs.vexity
  }
}

case class GtConstraint(lhs:Expression, rhs:Expression) extends SignedConstraint {
  require(lhs.size == rhs.size,
    s"Cannot create inequality constraint between expressions of size ${lhs.size} and ${rhs.size}")

  override val expression = lhs - rhs

  override val vexity = lhs.vexity - rhs.vexity match {
    case ConvexVexity => NotDcp
    case _ => lhs.vexity - rhs.vexity
  }
}

case class ConeConstraint(expr:Expression, cone:ConeType) extends Constraint{
  def isValid = List(AffineVexity, ConstantVexity) contains expr.vexity

  //override val conicForm = ConicForm(Constant(0), Array(), Array(this))
}