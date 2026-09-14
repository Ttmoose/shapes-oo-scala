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
    assert(scale(simpleRectangle, 2) == Shape.Rectangle(160,240))
  }

  test("scale simple ellipse") {
    assert(scale(simpleEllipse, 2) == Shape.Ellipse(100, 60))
  }

  test("scale simple location") {
    assert(scale(simpleLocation, 2) == Shape.Location(140, 60, Shape.Rectangle(160, 240)))
  }

  test("scale basic group") {
    assert(scale(basicGroup, 2) == Shape.Group(
      Shape.Ellipse(100, 60),
      Shape.Rectangle(40, 80) 
    ))
  }

  test("scale complex group") {
    assert(scale(complexGroup, 2) == 
      Shape.Location(100, 200,
        Shape.Group(
          Shape.Ellipse(40, 80),
          Shape.Location(300, 100,
          Shape.Group(
            Shape.Rectangle(100, 60),
            Shape.Rectangle(600, 120),
            Shape.Location(200, 400,
              Shape.Ellipse(100, 60)
            )
        )),
        Shape.Rectangle(200, 400)
      ))
    )
  }