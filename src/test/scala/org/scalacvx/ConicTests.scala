package org.scalacvx

import breeze.linalg.DenseMatrix._
import breeze.linalg.{DenseVector, DenseMatrix}
import org.scalacvx.atoms.Variable
import org.scalacvx.conic.{ConeType, SecondOrderCone, ConicForm}
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by lorenzo on 8/22/15.
 */
class ConicTests extends FlatSpec with Matchers {

  val xVar = Variable()
  val yVar = Variable()

  "A conic form" should "be composable" in {
    println(xVar.canonicalize + yVar.canonicalize)

  }

}
