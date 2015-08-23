package org.scalacvx

import org.scalacvx.atoms.{Constant, Variable}
import org.scalacvx.dcp.{NotDcp, ConvexVexity}
import org.scalatest.{Matchers, FlatSpec}
import org.scalacvx.Problem._
import org.scalacvx.atoms.Expression._

/**
 * Created by lorenzo on 8/23/15.
 */
class ProblemTests extends FlatSpec with Matchers {

  "A problem" should "recognize whether it can be solved" in {

    val x = Variable()

    val validProblem = minimize(abs(x)) subjectTo (x >= Constant(0))
    validProblem.vexity shouldBe ConvexVexity

    val invalidProblem = maximize(abs(x)) subjectTo (x < Constant(0))
    an [Exception] should be thrownBy (invalidProblem.vexity)
  }
}
