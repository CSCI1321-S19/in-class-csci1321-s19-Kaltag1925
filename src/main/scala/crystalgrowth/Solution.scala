package crystalgrowth

import akka.actor.Actor
import scalafx.scene.image.WritableImage

class Solution(img: WritableImage) extends Actor {
  import Solution._
  def receive = {
    case CheckLocation(x, y) =>
      sender ! ???
    case m => println("Unhandled message in Solution: " + m)
  }
}

object Solution {
  case class CheckLocation(x: Int, y: Int)
}