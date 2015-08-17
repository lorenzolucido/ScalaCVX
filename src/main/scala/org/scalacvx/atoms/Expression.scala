package org.scalacvx.atoms

import org.scalacvx.dcp.{Monotonicity, Sign, Vexity}

/**
 * Created by lorenzo on 8/16/15.
 */
trait Expression {

  val size: Int
  val length: Int

  def monotonicity: Monotonicity = ???
  def vexity: Vexity = ???
  def curvature: Vexity = ???
  def evaluate: Unit = ???
  def sign: Sign = ???

}
