package org.scalacvx

/**
 * Created by lorenzo on 8/16/15.
 */

import org.scalatest._
import org.scs._



class ScsTest extends FlatSpec with Matchers {


  "SCS solver" should "solve a random linear program" in {
    val m = 50
    val n = 30

    val p = new Settings
    val d = new Data
    val isolver = new IndirectSolver
    val dsolver = new DirectSolver
    val cp = new RandomLinearProgram(m, n, d, p, dsolver)


    val sol = cp.solve
    sol.getInfo.getStatus should be ("Solved")
  }


}
