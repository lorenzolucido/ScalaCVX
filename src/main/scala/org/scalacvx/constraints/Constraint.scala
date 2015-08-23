package org.scalacvx.constraints

import org.scalacvx.atoms.Expression
import org.scalacvx.conic.ConicForm
import org.scalacvx.dcp.{NotDcp, AffineVexity, Vexity}

/**
 * Created by lorenzo on 8/16/15.
 */
sealed trait Constraint {

  val lhs: Expression
  val rhs: Expression
  val vexity:Vexity
  val conicForm:ConicForm

}

case class EqualityConstraint(lhs:Expression, rhs:Expression) extends Constraint {

  val vexity = lhs.vexity - rhs.vexity match {
    case AffineVexity => AffineVexity
    case _ => NotDcp
  }

  val conicForm = ???


}


object EqualityConstraint {

}