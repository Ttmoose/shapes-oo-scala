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
    assert(size(simpleRectangle) == 9600)
  }

  test("size of simple ellipse") {
    assert(size(simpleEllipse) == math.Pi.toInt * 50 * 30)
  }

  test("size of simple location") {
    assert(size(simpleLocation) == 9600)
  }

  test("size of basic group") {
    assert(size(basicGroup) == 5300)
  }

  test("size of complex group") {
    assert(size(complexGroup) == 46400)
  }