package org.scalacvx

import org.scalacvx.atoms.{Constant, Variable}
import org.scalacvx.constraints.{GtConstraint, EqualityConstraint}
import org.scalacvx.dcp.{AffineVexity, NotDcp, ConvexVexity}
import org.scalatest.{Matchers, FlatSpec}
import org.scalacvx.ConvexProblem._
import org.scalacvx.atoms.ExpressionImplicits._

/**
 * Created by lorenzo on 8/23/15.
 */
class ProblemTests extends FlatSpec with Matchers {

  "A problem" should "recognize whether it can be solved" in {

    val x = Variable()

    abs(x).vexity shouldBe ConvexVexity
    (x >= 0.0) shouldBe a [GtConstraint]

    val validProblem = minimize(abs(x)) subjectTo (x >= 0.0)
    validProblem shouldBe a [ConvexProblem]

    //val invalidProblem =
    an [IllegalArgumentException] should be thrownBy (maximize(abs(x)) subjectTo (x < 0.0)) //
  }
}
