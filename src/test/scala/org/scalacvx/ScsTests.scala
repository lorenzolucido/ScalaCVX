package org.scalacvx

/**
 * Created by lorenzo on 8/16/15.
 */

import org.scalatest._
import org.scs._




class ScsTests extends FlatSpec with Matchers {

  val isolver = new IndirectSolver
  val dsolver = new DirectSolver

  def roundAt(d:Double, at:Int) = Math.round(d * Math.pow(10,at)) / Math.pow(10,at)

  "SCS solver" should "solve a random linear program" in {
    val nrows = 50
    val ncols = 30

    val settings = new Settings
    settings.setVerbose(false)
    val data = new Data

    val cp = new RandomLinearProgram(nrows, ncols, data, settings, dsolver)

    val sol = cp.solve
    sol.getInfo.getStatus should be ("Solved")

    cp.setSolver(isolver)
    cp.solve
  }

  "SCS solver" should "solve: minimize x^2 + x" in {
    //val nrows = 1
    //val ncols = 1

    // Data: AMatrix, sizes -> this is a column-compressed sparse matrix
    // i.e. the last argument is the index of the value that indicates the last nnz in the column
    val aMat = new AMatrix(3,2,Array(-2.0,-1.0,-1.0),Array(2,0,1),Array(0,1,3))
    /*
        A matrix: |  0  -1 |
                  |  0  -1 |
                  | -2   0 |
     */
    val data = new Data(aMat,Array(1.0,-1.0,0.0),Array(1.0,1.0))
    //  b: | 1  -1  0 |^T         c: | 1  1 |


    println(aMat.getNumRows + " | " + aMat.getNumCols)

    val cone = new Cone
    cone.setQ(Array(3)) // 3 SOC constraints

    val settings = new Settings
    settings.setVerbose(false)

    val coneProg = new ConeProgram(data, cone, settings, isolver)

    val sol = coneProg.solve

    sol.getInfo.getStatus should be("Solved")           // Problem status
    roundAt(sol.getX()(0),2) should equal(-0.5)         // Value of X that minimizes the problem
    roundAt(sol.getInfo.getPobj,2) should equal(-0.25)  // Optimal value
  }


}
