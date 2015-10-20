package org.scalacvx

import org.scalacvx.atoms.Variable
import org.scalatest.{Matchers, FlatSpec}
import org.scalacvx.atoms.ExpressionImplicits._

/**
 * Created by lorenzo on 8/23/15.
 */
class ConstraintTests extends FlatSpec with Matchers {
  /*
  val xVar = Variable(2)
  val yVar = Variable(2)

  val xMat = Variable(3,2)

  "A constraint" should "have appropriate vexity" in {
    (xVar == yVar) shouldBe an [EqualityConstraint]
    (abs(xVar) < yVar) shouldBe a [LtConstraint]
    (-xVar >= abs(yVar)) shouldBe a [GtConstraint]
  }

  "A constraint" should "require identical dimensions of both sides" in {
    an [IllegalArgumentException] should be thrownBy (xMat <= xVar)
  }

  */

}
