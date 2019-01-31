package polymorphism

import scalafx.scene.paint.Color

class Square(length: Double, color: Color) extends Rectangle(length, length, color) {
            // Don't use a 'val' for length as it is passed to the supertype
}