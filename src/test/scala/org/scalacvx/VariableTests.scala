package org.scalacvx

import org.scalacvx.atoms.Variable
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by lorenzo on 8/23/15.
 */
class VariableTests extends FlatSpec with Matchers {

  "A variable" should "return proper sizes and length" in {

    val x = Variable(2,3)
    x.length should be(6)
    x.size should be((2,3))
    x.size._1 should be(2)
    x.size._2 should be(3)

    val y = Variable(3)
    y.length should be(3)
    y.size should be((3,1))

    val z = Variable()
    z.length should be(1)
    z.size should be((1,1))

  }
}
