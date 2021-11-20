package uk.co.slightlymore.raytracer

object Utils {
  val EPSILON = 1e-6
  def equals(x: Double, y: Double): Boolean = (x - y).abs < EPSILON
}
