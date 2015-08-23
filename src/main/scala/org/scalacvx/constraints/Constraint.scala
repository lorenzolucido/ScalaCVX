package org.scalacvx.constraints

import org.scalacvx.atoms.Expression
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp._

/**
 * Created by lorenzo on 8/16/15.
 */
sealed trait Constraint {

  val lhs: Expression
  val rhs: Expression
  val vexity:Vexity
  //val conicForm:ConicForm // To be implemented

}

case class EqualityConstraint(lhs:Expression, rhs:Expression) extends Constraint {
  require(lhs.size == rhs.size,
    s"Cannot create equality constraint between expressions of size ${lhs.size} and ${rhs.size}")

  val vexity = lhs.vexity - rhs.vexity match {
      case ConvexVexity | ConcaveVexity => NotDcp
      case _ => lhs.vexity - rhs.vexity
    }
}

case class LtConstraint(lhs:Expression, rhs:Expression) extends Constraint {
  require(lhs.size == rhs.size,
    s"Cannot create inequality constraint between expressions of size ${lhs.size} and ${rhs.size}")

  val vexity = lhs.vexity - rhs.vexity match {
    case ConcaveVexity => NotDcp
    case _ => lhs.vexity - rhs.vexity
  }
}

case class GtConstraint(lhs:Expression, rhs:Expression) extends Constraint {
  require(lhs.size == rhs.size,
    s"Cannot create inequality constraint between expressions of size ${lhs.size} and ${rhs.size}")

  val vexity = lhs.vexity - rhs.vexity match {
    case ConvexVexity => NotDcp
    case _ => lhs.vexity - rhs.vexity
  }
}
