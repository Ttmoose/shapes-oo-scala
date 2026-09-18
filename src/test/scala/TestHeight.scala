package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

class TestHeight extends AnyFunSuite:
  import TestFixtures.*

  def height(shape: Shape): Int = shape match
    case Shape.Rectangle(_, h) => h
    case Shape.Ellipse(_, b)   => 2 * b
    case Shape.Location(_, y, inner) => y + height(inner)
    case Shape.Group(shapes*) => shapes.map(height).max

  test("height of simple rectangle") {
    simpleRectangle match
      case Shape.Rectangle(_, h) =>
        assert(height(simpleRectangle) == h)
      case _ =>
        fail("simpleRectangle is not a Rectangle")
  }

  test("height of simple ellipse") {
    simpleEllipse match
      case Shape.Ellipse(_, b) =>
        assert(height(simpleEllipse) == 2 * b)
      case _ =>
        fail("simpleEllipse is not an Ellipse")
  }

  test("height of simple location") {
    simpleLocation match
      case Shape.Location(_, y, inner) =>
        assert(height(simpleLocation) == y + height(inner))
      case _ =>
        fail("simpleLocation is not a Location")
  }

  test("height of basic group") {
    basicGroup match
      case Shape.Group(Shape.Ellipse(a, b), Shape.Rectangle(w, h)) =>
        assert(height(basicGroup) == math.max(2 * b, h))
      case _ =>
        fail("basicGroup is not a Group")
  }

  test("height of complex group") {
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
        assert(height(complexGroup) ==
          y +
          math.max(
            2 * b,
            math.max(
              y2 + math.max(
                h,
                math.max(
                  h2,
                  y3 + 2 * b2
                )
              ),
              h3
            )
          )
        )
      case _ =>
        fail("complexGroup is not the correct height")
  }