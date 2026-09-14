package edu.luc.cs.laufer.cs371.shapes

import doodle.core._
import doodle.java2d._
import doodle.syntax.layout._
import doodle.syntax.style._


object draw:
  def apply(s: Shape): Picture[Unit] = s match
    case Shape.Rectangle(width, height) =>
      Picture.rectangle(width.toDouble, height.toDouble).strokeColor(Color.black)

    case Shape.Ellipse(semiMajorAxis, semiMinorAxis) =>
      Picture.circle(semiMajorAxis.toDouble * 2).strokeColor(Color.black)

    case Shape.Location(x, y, shape) =>
      apply(shape).at(x.toDouble, y.toDouble)

    case Shape.Group(shapes*) =>
      shapes.map(apply).reduce(_ on _)