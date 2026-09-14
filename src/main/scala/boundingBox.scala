package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w, h) =>
      Location(0, 0, Rectangle(w, h)) 

    case Ellipse(semiMajorAxis, semiMinorAxis) =>
      Location(-semiMajorAxis, -semiMinorAxis, Rectangle(2 * semiMajorAxis, 2 * semiMinorAxis))

    case Location(x, y, shape) =>
      apply(shape) match
        case Location(x1, y1, Rectangle(w, h)) =>
          Location(x + x1, y + y1, Rectangle(w, h))

    case Group(shapes*) =>
      val boxes = shapes.map(apply)
      val minX = boxes.map(_.x).min(using Ordering.Int)
      val minY = boxes.map(_.y).min(using Ordering.Int)
      val maxX = boxes.map(b => b.x + b.shape.asInstanceOf[Rectangle].w).max(using Ordering.Int)
      val maxY = boxes.map(b => b.y + b.shape.asInstanceOf[Rectangle].h).max(using Ordering.Int)
      Location(minX, minY, Rectangle(maxX - minX, maxY - minY))