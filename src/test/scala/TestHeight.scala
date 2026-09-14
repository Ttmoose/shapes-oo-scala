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
    assert(height(simpleRectangle) == 120)
  }

  test("height of simple ellipse") {
    assert(height(simpleEllipse) == 60)
  }

  test("height of simple location") {
    assert(height(simpleLocation) == 150)
  }

  test("height of basic group") {
    assert(height(basicGroup) == 60)
  }

  test("height of complex group") {
    assert(height(complexGroup) == 410)
  }