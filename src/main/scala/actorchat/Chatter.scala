package actorchat

import akka.actor.Actor
import java.io.PrintStream
import java.net.Socket
import java.io.BufferedReader

class Chatter(sock: Socket, in: BufferedReader, out: PrintStream, name: String) extends Actor {
  import Chatter._
  def receive = {
    case CheckInput =>
      if (in.ready()) {
        val input = in.readLine
        context.parent ! ChatManager.PrintToAll(name + ": " + input)
      }
    case PrintMessage(message) =>
      
    case m => println("Unprocessed message in Chatter " + self + ": " + m)
  }
}

object Chatter {
  case object CheckInput
  case class PrintMessage(message: String)
}