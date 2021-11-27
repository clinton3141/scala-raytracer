package uk.co.slightlymore.raytracer

class Colour(val red: Double, val green: Double, val blue: Double) {
  def +(that: Colour) = binary_operator(_ + _, that)

  def -(that: Colour) = binary_operator(_ - _, that)

  // Multiplication using the Hadamard product
  def *(that: Colour) = binary_operator(_ * _, that)

  def *(s: Double) = Colour(this.red * s, this.green * s, this.blue * s)

  def ==(that: Colour) = Utils.equals(this.red, that.red) &&
    Utils.equals(this.green, that.green) &&
    Utils.equals(this.blue, that.blue)

  private def binary_operator(op: (Double, Double) => Double, that: Colour) =
    Colour(
      op(this.red, that.red),
      op(this.green, that.green),
      op(this.blue, that.blue)
    )
}

object Colour {
  def apply(red: Double, green: Double, blue: Double) = new Colour(red, green, blue)
}
