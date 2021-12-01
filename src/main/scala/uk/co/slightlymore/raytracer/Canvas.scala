package uk.co.slightlymore.raytracer

import java.awt.Color

class Canvas(val width: Int, val height: Int, background: Colour) {
  val maxColour = 255;

  val pixels: Array[Array[Colour]] = Array.fill(height)(Array.fill(width)(background))

  def writePixel(col: Int, row: Int, colour: Colour) = {
    this.pixels(row)(col) = colour;
  }

  def readPixel(col: Int, row: Int): Colour = this.pixels(row)(col)

  def toPPM(): String = {
    val header = s"P3\n$width $height\n$maxColour"

    // TODO: definite scope for improvement. Not very elegant
    val channels = pixels.foldLeft(List[String](""))((acc, row) => {
      acc ++ row
        .foldLeft(List[String](""))((res, px) => {
          val r = channelValue(px.red)
          val g = channelValue(px.green)
          val b = channelValue(px.blue)
          val lines = List[String](res.last)
          val result = res.last.length() match {
            case l if l == 0                                               => List(s"$r $g $b ")
            case l if l <= 70 - (4 + r.length() + g.length() + b.length()) => List(s"${res.last}${r} ${g} ${b} ")
            case l if l <= 70 - (3 + r.length() + g.length())              => List(s"${res.last}${r} ${g} ", s"$b ")
            case l if l <= 70 - (2 + r.length())                           => List(s"${res.last}${r}", s"${g} ${b} ")
            case _                                                         => List(res.last, s"$r $g $b ")
          }

          res.reverse.tail.reverse ++ result
        })
        .map(_.replaceAll("\\s+$", ""))
    })

    header + (channels.mkString("\n"))
  }

  def channelValue(channel: Double): String = Math.round(channel * maxColour).toInt match {
    case x if x < 0         => 0.toString()
    case x if x > maxColour => maxColour.toString()
    case x                  => x.toString()
  }
}

object Canvas {
  def apply(width: Int, height: Int, background: Colour = Colour(0, 0, 0)) = new Canvas(width, height, background)
}
