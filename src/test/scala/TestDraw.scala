package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File
import TestFixtures._

class TestDraw extends AnyFunSuite:

  // Ensure the output directory exists
  private val outputDir = new File("test-output")
  if (!outputDir.exists()) {
    outputDir.mkdirs()
  }

  test("draw simple ellipse") {
    val image = ShapeRenderer.renderToImage(simpleEllipse, 200, 100)
    ImageIO.write(image, "png", new File(outputDir, "simple-ellipse.png"))
    assert(image.getWidth == 200)
    assert(image.getHeight == 100)
  }

  test("draw simple rectangle") {
    val image = ShapeRenderer.renderToImage(simpleRectangle, 200, 200)
    ImageIO.write(image, "png", new File(outputDir, "simple-rectangle.png"))
    assert(image.getWidth == 200)
    assert(image.getHeight == 200)
  }

  test("draw simple location") {
    val image = ShapeRenderer.renderToImage(simpleLocation, 300, 300)
    ImageIO.write(image, "png", new File(outputDir, "simple-location.png"))
    assert(image.getWidth == 300)
    assert(image.getHeight == 300)
  }

  test("draw basic group") {
    val image = ShapeRenderer.renderToImage(basicGroup, 300, 300)
    ImageIO.write(image, "png", new File(outputDir, "basic-group.png"))
    assert(image.getWidth == 300)
    assert(image.getHeight == 300)
  }

  test("draw simple group") {
    val image = ShapeRenderer.renderToImage(simpleGroup, 500, 500)
    ImageIO.write(image, "png", new File(outputDir, "simple-group.png"))
    assert(image.getWidth == 500)
    assert(image.getHeight == 500)
  }

  test("draw complex group") {
    val image = ShapeRenderer.renderToImage(complexGroup, 600, 600)
    ImageIO.write(image, "png", new File(outputDir, "complex-group.png"))
    assert(image.getWidth == 600)
    assert(image.getHeight == 600)
  }