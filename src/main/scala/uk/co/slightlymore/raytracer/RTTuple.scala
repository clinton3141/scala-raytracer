package uk.co.slightlymore.raytracer

// TODO: remember what the right pattern is!!
trait RTTuple {
  val x: Double
  val y: Double
  val z: Double
  val w: Double
}

class RTPoint(val x: Double, val y: Double, val z: Double, val w: Double) extends RTTuple {}

class RTVector(val x: Double, val y: Double, val z: Double, val w: Double) extends RTTuple {}

object RTTuple {
  def apply(x: Double, y: Double, z: Double, w: Double) = {
    if (w == 0) new RTVector(x, y, z, w) else new RTPoint(x, y, z, w)
  }
}