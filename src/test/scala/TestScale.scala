package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

class TestScale extends AnyFunSuite:
  import TestFixtures.*

  def scale(shape: Shape, factor: Int): Shape = shape match
    case Shape.Rectangle(w, h) => Shape.Rectangle(w * factor, h * factor)
    case Shape.Ellipse(a, b)   => Shape.Ellipse(a * factor, b * factor)
    case Shape.Location(x, y, inner) => Shape.Location(x * factor, y * factor, scale(inner, factor))
    case Shape.Group(shapes*) => Shape.Group(shapes.map(scale(_, factor)) *)

  test("scale simple rectangle") {
    simpleRectangle match
      case Shape.Rectangle(width, height) =>
        assert(scale(simpleRectangle, 2) == Shape.Rectangle(width * 2, height * 2))
      case _ =>
        fail("simpleRectangle is not a Rectangle")
  }

  test("scale simple ellipse") {
    simpleEllipse match
      case Shape.Ellipse(a,b) => 
        assert(scale(simpleEllipse, 2) == Shape.Ellipse(a * 2, b * 2))
      case _ =>
        fail("simpleElipse is not an Elipse")
  }

  test("scale simple location") {
    simpleLocation match
      case Shape.Location(x, y, inner) =>
        assert(scale(simpleLocation, 2) == Shape.Location(x * 2, y * 2, scale(simpleRectangle, 2)))
      case _ =>
        fail("simpleLocation is not a Location")
  }

  test("scale basic group") {
    basicGroup match
      case Shape.Group(Shape.Ellipse(a, b), Shape.Rectangle(w, h)) =>
        assert(scale(basicGroup, 2) == Shape.Group(
          Shape.Ellipse(a * 2, b * 2),
          Shape.Rectangle(w * 2, h * 2)
        ))
      case _ =>
        fail("basicGroup is not a Group")
  }

  test("scale complex group") {
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
        assert(scale(complexGroup, 2) == Shape.Location(
          x * 2, y * 2,
          Shape.Group(
            Shape.Ellipse(a * 2, b * 2),
            Shape.Location(x2 * 2, y2 * 2,
              Shape.Group(
                Shape.Rectangle(w * 2, h * 2),
                Shape.Rectangle(w2 * 2, h2 * 2),
                Shape.Location(x3 * 2, y3 * 2,
                  Shape.Ellipse(a2 * 2, b2 * 2)
                )
              )
            ),
            Shape.Rectangle(w3 * 2, h3 * 2)
          )
        ))
      case _ =>
        fail("complexGroup is not a Location")
  }