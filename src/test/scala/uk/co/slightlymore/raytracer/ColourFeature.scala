package uk.co.slightlymore.raytracer

class ColourFeature extends Feature {
  Feature("Colours") {
    Scenario("Colours are (red, green, blue) tuples") {
      Given("c <- Colour(-0.5, 0.4, 1.7)")
      val c = Colour(-0.5, 0.4, 1.7)

      Then("c.red = -0.5")
      assert(c.red == -0.5)

      And("c.green = 0.4")
      assert(c.green == 0.4)

      And("c.blue = 1.7")
      assert(c.blue == 1.7)
    }

    Scenario("Adding colours") {
      Given("c1 <- Colour(0.9, 0.6, 0.75)")
      val c1 = Colour(0.9, 0.6, 0.75)

      And("c2 <- Colour(0.7, 0.1, 0.25)")
      val c2 = Colour(0.7, 0.1, 0.25)

      Then("c1 + c2 = Color(1.6, 0.7, 1.0)")
      assert(c1 + c2 == Colour(1.6, 0.7, 1.0))
    }

    Scenario("Subtracting colours") {
      Given("c1 <- Colour(0.9, 0.6, 0.75)")
      val c1 = Colour(0.9, 0.6, 0.75)

      And("c2 <- Colour(0.7, 0.1, 0.25)")
      val c2 = Colour(0.7, 0.1, 0.25)

      Then("c1 - c2 = Colour(0.2, 0.5, 0.5)")
      assert(c1 - c2 == Colour(0.2, 0.5, 0.5))
    }

    Scenario("Multiplying a colour by a scalar") {
      Given("c1 <- Colour(0.2, 0.3, 0.4)")
      val c1 = Colour(0.2, 0.3, 0.4)

      Then("c1 * 2 = Colour(0.4, 0.6, 0.8)")
      assert(c1 * 2 == Colour(0.4, 0.6, 0.8))
    }

    Scenario("Multiplying colours") {
      Given("c1 <- Colour(1, 0.2, 0.4)")
      val c1 = Colour(1, 0.2, 0.4)

      And("c2 <- Colour(0.9, 1, 0.1")
      val c2 = Colour(0.9, 1, 0.1)

      Then("c1 * c2 = Colour(0.9, 0.2, 0.04)")
      assert(c1 * c2 == Colour(0.9, 0.2, 0.04))
    }
  }
}
