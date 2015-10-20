package org.scalacvx


import org.scalacvx.atoms.ExpressionImplicits._
import org.scalacvx.atoms._
import org.scalacvx.dcp._
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by lorenzo on 9/6/15.
 */
class ExpressionTests extends FlatSpec with Matchers {

  "The sum of two affine expression" should "be an affine expression" in {
    /*
    val x = Variable(2)
    val y = Variable(2)

    x shouldBe an [AffineExpressionAbstract]
    //y shouldBe an [Expression[Affine]]
    x + y shouldBe an [AffineExpression]
    -x shouldBe an [AffineExpression]
    (-x).size shouldBe x.size
    */
  }

  "An affine expression" should "by definition, be also convex" in {
    //val x = Variable()
    //x/.vexity shouldBe an [ConvexVexity]
    //x shouldBe an [Expression[Convex]]
  }

  "A convex expression" should "in the general case, not be affine" in {
    //val x = Variable()
    //AbsAtom(x) shouldBe an [Expression[Convex]]
    //AbsAtom(x) should not be an [Expression[Affine]]
  }

  // ------------- TYPE-LEVEL EXPRESSIONS -------------
  "An expression" should "verify" in {

    val concaveExp = new Expression[Concave] {}
    val convexExp = new Expression[Convex] {}
    val affineExp = new Expression[Affine] {}
    val constantExp = new Expression[ConstantVex] {}

    val nn = - concaveExp

    val negConcaveExp:      Expression[Convex]      = - concaveExp
    val convexPlusConvex:   Expression[Convex]      = convexExp + negConcaveExp
    val concaveMinusConvex: Expression[Concave]     = concaveExp - convexExp
    val affPlusConvex:      Expression[Convex]      = affineExp + convexExp
    val affPlusConst:       Expression[Affine]      = affineExp + constantExp
    val constPlusConst:     Expression[ConstantVex] = constantExp + constantExp

    val absConvex = abs(affPlusConvex)
    val absConcave = abs(concaveMinusConvex)
    val absAffine = abs(affineExp)
    val absConstant = abs(constantExp)
  }

  "A constant" should "verify" in {
    //val const = Constant(-3.3)
  }


}
