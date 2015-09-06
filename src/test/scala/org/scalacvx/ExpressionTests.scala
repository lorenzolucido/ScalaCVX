package org.scalacvx

import org.scalacvx.atoms.affine.AddAtom
import org.scalacvx.atoms.{Expression, AffineExpression, Variable}
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by lorenzo on 9/6/15.
 */
class ExpressionTests extends FlatSpec with Matchers {

  "The sum of two affine expression" should "be an affine expression" in {
    val x = Variable()
    val y = Variable()

    x shouldBe an [AffineExpression]
    y shouldBe an [AffineExpression]
    AddAtom(x, y) shouldBe an [AffineExpression]
    x + y shouldBe an [AffineExpression]

  }

}
