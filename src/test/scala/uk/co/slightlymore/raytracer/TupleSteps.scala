package uk.co.slightlymore.raytracer

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers

class TupleSteps extends ScalaDsl with EN with Matchers {
  var tuple: RTTuple = _

  Given("""a ← tuple\({double}, {double}, {double}, {double})""") { (x: Double, y: Double, z: Double, w: Double) =>
    tuple = RTTuple(x, y, z, w)
  }

  Then("""a.x = {double}""") { (x: Double) =>
    tuple.x should be (x)
  }

  Then("""a.y = {double}""") { (y: Double) =>
    tuple.y should be (y)
  }

  Then("""a.z = {double}""") { (z: Double) =>
    tuple.z should be (z)
  }

  Then("""a.w = {double}""") { (w: Double) =>
    tuple.w should be (w)
  }

  Then("""a is a point""") { () =>
    tuple.isInstanceOf[RTPoint] should be (true)
  }

  Then("""a is not a vector""") { () =>
    tuple.isInstanceOf[RTVector] should be (false)
  }
}