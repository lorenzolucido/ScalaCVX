package org.scalacvx.solvers

import org.scalacvx.constraints.Constraint

/**
 * Created by lorenzo on 8/31/15.
 */
trait Solver {

  def solve()
}


object Solver {

  def bestSolver(constraints:Array[Constraint]):Solver = constraints match {
    case _ => ScsSolver()
  }

}
