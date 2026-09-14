package edu.luc.cs.laufer.cs371.shapes

import java.awt.image.BufferedImage
import java.awt.{Graphics2D, Color}

object ShapeRenderer:
  def renderToImage(shape: Shape, width: Int, height: Int): BufferedImage =
    val image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
    val graphics = image.createGraphics()
    graphics.setColor(Color.WHITE)
    graphics.fillRect(0, 0, width, height)
    graphics.setColor(Color.BLACK)
    drawShape(graphics, shape)
    graphics.dispose()
    image

  private def drawShape(graphics: Graphics2D, shape: Shape): Unit = shape match
    case Shape.Rectangle(w, h) =>
      graphics.drawRect(0, 0, w, h)

    case Shape.Ellipse(a, b) =>
      graphics.drawOval(0, 0, a * 2, b * 2)

    case Shape.Location(x, y, innerShape) =>
      graphics.translate(x, y)
      drawShape(graphics, innerShape)
      graphics.translate(-x, -y)

    case Shape.Group(shapes*) =>
      shapes.foreach(drawShape(graphics, _))