package edu.luc.cs.laufer.cs371.shapes

import doodle.core._
import doodle.java2d._
import doodle.syntax.all._
import doodle.syntax.style._
import doodle.syntax.layout._
import doodle.syntax.transform._

enum Shape derives CanEqual:
  case Rectangle(w: Int, h: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Ellipse(semiMajorAxis: Int, semiMinorAxis: Int)
  case Group(shapes: Shape*)
 
  def draw: Picture[Unit] = this match
    case Rectangle(width, height) =>
      Picture.rectangle(width.toDouble, height.toDouble).strokeColor(Color.black)

    case Ellipse(semiMajorAxis, semiMinorAxis) =>
      Picture.circle(semiMajorAxis.toDouble * 2).strokeColor(Color.black)

    case Location(x, y, shape) =>
      shape.draw.at(x.toDouble, y.toDouble)

    case Group(shapes*) =>
      shapes.map(_.draw).reduce(_ on _)