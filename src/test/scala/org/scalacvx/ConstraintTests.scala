package org.scalacvx

import org.scalacvx.atoms.Variable
import org.scalacvx.dcp.{ConcaveVexity, ConvexVexity, AffineVexity}
import org.scalatest.{Matchers, FlatSpec}
import org.scalacvx.atoms.Expression._

/**
 * Created by lorenzo on 8/23/15.
 */
class ConstraintTests extends FlatSpec with Matchers {

  val xVar = Variable(2)
  val yVar = Variable(2)

  val xMat = Variable(3,2)

  "A constraint" should "have appropriate vexity" in {
    (xVar == yVar).vexity shouldBe AffineVexity
    (abs(xVar) < yVar).vexity shouldBe ConvexVexity
    (-xVar >= abs(yVar)).vexity shouldBe ConcaveVexity
  }

  "A constraint" should "require identical dimensions of both sides" in {
    an [IllegalArgumentException] should be thrownBy (xMat <= xVar)
  }



}
