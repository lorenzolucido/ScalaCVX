package org.scalacvx

import breeze.linalg.DenseMatrix._
import breeze.linalg.{DenseVector, DenseMatrix}
import org.scalacvx.conic.{ConeType, SecondOrderCone, ConicForm}
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by lorenzo on 8/22/15.
 */
class ConicTests extends FlatSpec with Matchers {

  "A conic epigraph form" should "be composable" in {
    val C = DenseMatrix((1.0, 2.0),(3.0, 4.0))
    val d = DenseVector(1.0, 2.0)
    val A = Array(DenseMatrix((1.0, 2.0),(3.0, 4.0)))
    val b = Array(DenseVector(1.0, 2.0))
    val K = Array[ConeType](SecondOrderCone)

    // Tests to be rewritten
    //val f = ConicForm(C, d, A, b, K)

    //val g = f o f // Used in order to test that matrix multiplications are correct
    //println(g)
  }

}
