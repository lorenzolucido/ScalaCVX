package org.scalacvx

/**
 * Created by lorenzo on 8/16/15.
 */


import org.scalacvx.dcp._
import org.scalatest._

class DcpTests extends FlatSpec with Matchers {

  "The set of rules for vexities" should "verify" in {
    - ConvexVexity should be (ConcaveVexity)
    - ConcaveVexity should be (ConvexVexity)
    ConcaveVexity + AffineVexity should be (ConcaveVexity)
    ConstantVexity + ConvexVexity should be (ConvexVexity)
    - ConcaveVexity - ConcaveVexity should be (ConvexVexity)
    - AffineVexity - ConstantVexity should be (AffineVexity)
    ConvexVexity + NotDcp should be (NotDcp)
    - AffineVexity + ConstantVexity + ConvexVexity should be (ConvexVexity)
  }

}
