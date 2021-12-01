package uk.co.slightlymore.raytracer

class CanvasFeature extends Feature {
  Feature("Canvas") {
    Scenario("Creating a canvas") {
      When("c <- Canvas(10, 20)")
      val c = Canvas(10, 20)

      Then("c.width = 10")
      assert(c.width == 10)
      And("c.height = 20")
      assert(c.height == 20)
      And("Every pixel of c is Colour(0, 0, 0)")
      assert(c.pixels.forall(_.forall(_ == Colour(0, 0, 0))))
    }

    Scenario("Writings pixels to a canvas") {
      When("c <- Canvas(10, 20)")
      val c = Canvas(10, 20)

      And("red <- Colour(1, 0, 0)")
      val red = Colour(1, 0, 0)

      When("c.write_pixel(2, 3, red)")
      c.writePixel(3, 15, red)

      Then("c.pixel_at(2, 3) == red")
      assert(c.readPixel(3, 15) == red)
    }

    Scenario("Constructing the PPM header") {
      Given("c <- Canvas(5, 3)")
      val c = Canvas(5, 3)

      When("ppm <- c.to_ppm()")
      val ppm = c.toPPM()

      Then("Lines 1-3 of ppm are P3\n5 3\n255")
      assert(ppm.split("\n").take(3).mkString("\n") == "P3\n5 3\n255")
    }

    Scenario("Constructing the PPM pixel data") {
      Given("c <- Canvas(5, 3)")
      val c = Canvas(5, 3)

      And("Colours are written to the canvas")
      c.writePixel(0, 0, Colour(1.5, 0, 0))
      c.writePixel(2, 1, Colour(0, 0.5, 0))
      c.writePixel(4, 2, Colour(-0.5, 0, 1))

      Then("Lines 4-7 of ppm are as expected")
      val ppm = c.toPPM()
      val expected = "255 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 128 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0 0 0 255";
      assert(
        ppm.split("\n").slice(3, 6).mkString("\n") == expected
      )
    }

    Scenario("Splitting long lines in PPM files") {
      Given("c <- Canvas(10, 2, Colour(1, 0.8, 0.6))")
      val c = Canvas(10, 2, Colour(1, 0.8, 0.6))

      Then("Lines 4-8 of the PPM are as expected")
      val ppm = c.toPPM()
      val expected =
        "255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204\n153 255 204 153 255 204 153 255 204 153 255 204 153\n255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204\n153 255 204 153 255 204 153 255 204 153 255 204 153";
      assert(
        ppm.split("\n").slice(3, 7).mkString("\n") == expected
      )

    }
  }
}
