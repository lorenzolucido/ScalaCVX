package org.scalacvx

import org.scalacvx.atoms.Variable
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by lorenzo on 8/23/15.
 */
class VariableTests extends FlatSpec with Matchers {

  "A variable" should "return proper sizes and length" in {

    val x = Variable(2,3)
    x.length shouldBe 6
    x.size shouldBe (2,3)
    x.size._1 shouldBe 2
    x.size._2 shouldBe 3

    val y = Variable(3)
    y.length shouldBe 3
    y.size shouldBe (3,1)

    val z = Variable()
    z.length shouldBe 1
    z.size shouldBe (1,1)

  }
}
