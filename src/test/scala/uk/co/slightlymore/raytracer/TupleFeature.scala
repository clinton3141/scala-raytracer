package uk.co.slightlymore.raytracer

class TuplesFeature extends Feature {
  Feature("Tuples") {
    Scenario("A tuple with w=1.0 is a point") {
      Given("t ← tuple(4.3, -4.2, 3.1, 1.0)")
      val x = 4.3
      val y = -4.2
      val z = 3.1
      val w = 1.0
      val t = RTTuple(x, y, z, w)

      Then("t.x = 4.3")
      assert(t.x == x)

      And("t.y = 4.3")
      assert(t.y == y)

      And("t.z = 4.3")
      assert(t.z == z)

      And("t.w = 4.3")
      assert(t.w == w)

      And("a should be a Point")
      And("a should not be a Vector")
      t match {
        case RTPoint(_, _, _, _) => assert(true)
        case RTVector(_, _, _, _) => assert(false)
      }
    }
  }
}
