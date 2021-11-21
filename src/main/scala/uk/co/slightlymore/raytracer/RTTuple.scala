package uk.co.slightlymore.raytracer

// TODO: remember what the right pattern is!!
trait RTTuple {
  val x: Double
  val y: Double
  val z: Double
  val w: Double

  def ==(that: RTTuple): Boolean =
    Utils.equals(this.x, that.x) &&
      Utils.equals(this.y, that.y) &&
      Utils.equals(this.z, that.z) &&
      Utils.equals(this.w, that.w)

  def +(that: RTTuple): RTTuple =
    RTTuple(this.x + that.x, this.y + that.y, this.z + that.z, this.w + that.w)

  def -(that: RTTuple): RTTuple =
    RTTuple(this.x - that.x, this.y - that.y, this.z - that.z, this.w - that.w)

  def *(s: Double): RTTuple =
    RTTuple(this.x * s, this.y * s, this.z * s, this.w * s)

  def /(s: Double): RTTuple =
    RTTuple(this.x / s, this.y / s, this.z / s, this.w / s)

  def unary_-(): RTTuple =
    RTTuple(-this.x, -this.y, -this.z, -this.w)
}

case class RTPoint(val x: Double, val y: Double, val z: Double) extends RTTuple {
  val w = 1.0
}

case class RTVector(val x: Double, val y: Double, val z: Double) extends RTTuple {
  val w = 0.0

  def magnitude = math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w)

  def normalise = {
    val mag = this.magnitude
    RTVector(this.x / mag, this.y / mag, this.z / mag)
  }

  def dot(that: RTVector) = this.x * that.x + this.y * that.y + this.z * that.z

  def cross(that: RTVector) = RTVector(
    this.y * that.z - this.z * that.y,
    this.z * that.x - this.x * that.z,
    this.x * that.y - this.y * that.x
  )
}

object RTTuple {
  def apply(x: Double, y: Double, z: Double, w: Double) = {
    if (w == 0) new RTVector(x, y, z) else new RTPoint(x, y, z)
  }
}
