package org.scalacvx.constraints

import org.scalacvx.dcp.Vexity

/**
 * Created by lorenzo on 8/16/15.
 */
sealed trait Constraint {

  def vexity:Vexity = ???
}
