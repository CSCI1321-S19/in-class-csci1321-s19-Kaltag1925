package polymorphism

import scalafx.scene.paint.Color

class MutableSquare(_length: Double, color: Color) extends MutableRectangle(_length, _length, color) {
  override def width_=(w: Double) = {
    _width = w
    _height = w
  }
}