package org.scalacvx


import org.scalacvx.atoms.affine.AddAtom
import org.scalacvx.atoms._
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by lorenzo on 9/6/15.
 */
class ExpressionTests extends FlatSpec with Matchers {

  "The sum of two affine expression" should "be an affine expression" in {
    val x = Variable()
    val y = Variable()

    //x shouldBe an [Expression[Affine]]
    //y shouldBe an [Expression[Affine]]
    //AddAtom(x, y) shouldBe an [Expression[Affine]]
    //x + y shouldBe an [Expression[Affine]]
  }

  "An affine expression" should "by definition, be also convex" in {
    val x = Variable()
    //x shouldBe an [Expression[Affine]]
    //x shouldBe an [Expression[Convex]]
  }

  "A convex expression" should "in the general case, not be affine" in {
    val x = Variable()
    //AbsAtom(x) shouldBe an [Expression[Convex]]
    //AbsAtom(x) should not be an [Expression[Affine]]
  }
}
