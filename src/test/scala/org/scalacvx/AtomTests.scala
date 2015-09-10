package org.scalacvx

import org.scalacvx.atoms.Variable
import org.scalacvx.atoms.ExpressionImplicits._
import org.scalacvx.dcp.{ConvexVexity, AffineVexity}
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by lorenzo on 8/23/15.
 */
class AtomTests extends FlatSpec with Matchers {

  val aVar = Variable()
  val xVar = Variable(2)
  val yVar = Variable(2)
  val zVar = Variable(2)

  val AVarMat = Variable(2,2)
  val BVarMat = Variable(2,2)
  val CVarMat = Variable(2,2)

  "Two atoms" should "can be added" in {
    val atom = xVar + yVar
    atom.vexity should be(AffineVexity)
    atom.length should be(2)
  }

  "The absolute value of a valid atom" should "be convex" in {
    val atom = abs(xVar)
    atom.vexity should be(ConvexVexity)
  }

}
