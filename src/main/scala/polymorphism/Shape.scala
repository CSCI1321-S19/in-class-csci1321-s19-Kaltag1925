package polymorphism

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

abstract class Shape {
  def area: Double
  def perimeter: Double
}

object Shape {
  def main(args: Array[String]): Unit = {
    val rect = new Rectangle(3,4, Color.Black)
    printShapeData(rect)
    val circle = new Circle(3, Color.Red)
    printShapeData(circle)
    val square2 = new MutableSquare(5, Color.Blue)
    square2.width = 99 // <- will assign width to 99 and length to 5 if MutableSquare simply extends MutableRectangle
  }
  
  def printShapeData(s: Shape): Unit = {
    println(s"Area = ${s.area}")
    println(s"Perimeter = ${s.perimeter}")
  }
}