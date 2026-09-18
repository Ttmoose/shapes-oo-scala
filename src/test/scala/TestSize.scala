package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

class TestSize extends AnyFunSuite:
  import TestFixtures.*

  def size(shape: Shape): Int = shape match
    case Shape.Rectangle(w, h) => w * h
    case Shape.Ellipse(a, b)   => math.Pi.toInt * a * b
    case Shape.Location(_, _, inner) => size(inner)
    case Shape.Group(shapes*) => shapes.map(size).sum

  test("size of simple rectangle") {
    simpleRectangle match
      case Shape.Rectangle(width, height) =>
        assert(size(simpleRectangle) == width * height)
      case _ =>
        fail("simpleRectangle is not the correct size")
  }

  test("size of simple ellipse") {
    simpleEllipse match
      case Shape.Ellipse(a, b) =>
        assert(size(simpleEllipse) == math.Pi.toInt * a * b)
      case _ =>
        fail("simpleEllipse is not the correct size")
  }

  test("size of simple location") {
    simpleLocation match
      case Shape.Location(_, _, inner) =>
        assert(size(simpleLocation) == size(inner))
      case _ =>
        fail("simpleLocation is not the correct size")
  }

  test("size of complex group") {
    complexGroup match
      case Shape.Location(x, y, Shape.Group(
        Shape.Ellipse(a, b),
        Shape.Location(x2, y2, Shape.Group(
          Shape.Rectangle(w, h),
          Shape.Rectangle(w2, h2),
          Shape.Location(x3, y3, Shape.Ellipse(a2, b2))
        )),
        Shape.Rectangle(w3, h3)
      )) =>
        assert(size(complexGroup) ==
          math.Pi.toInt * a * b +
          w * h +
          w2 * h2 +
          math.Pi.toInt * a2 * b2 +
          w3 * h3
        )
      case _ =>
        fail("complexGroup is not the correct size")
  }