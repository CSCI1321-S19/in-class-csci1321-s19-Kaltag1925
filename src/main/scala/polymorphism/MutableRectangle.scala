package polymorphism

import scalafx.scene.paint.Color

class MutableRectangle(protected var _width: Double, protected var _height: Double, private var _color: Color) extends Shape {
                      // Protected so that subtypes can see it
  def width = _width
  def width_=(w: Double) = _width = w
  
  def height = _height
  def height_=(h: Double) = _height = h
  
  def color = _color
  def color_=(c: Color) = _color = c
  
  override def area: Double = width * height
  override def perimeter: Double = 2*width+2*height
}