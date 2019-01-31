package polymorphism

import scalafx.scene.paint.Color

class BadRectangle(private var _width: Double, private var _height: Double, color: Color) extends Rectangle(_width, _height, color) {
  def width_=(w: Double) = _width = w
  def height_=(h: Double) = _height = h
  override def area: Double = _width * _height
  override def perimeter: Double = 2*_width + 2*_height
  /*
   * This is why you would want 'final' on Rectangle
   * This rectangle violates the rule that Rectangle is immutable
   */
}