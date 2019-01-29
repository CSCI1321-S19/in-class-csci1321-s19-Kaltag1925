package mud

import scala.xml.XML

class Room(val name: String, 
    private val desc: String,
    private var items: List[Item],
    private val exits: Array[Int]){ //Private description cause description needs build
  def description(): String = ???
  def getExit(dir: Int): Option[Room] = ???
  def getItem(itemName: String): Option[Item] = ???
  def dropItem(item: Item): Unit = ???
}

object Room {
  val room = readRooms()
  
  def readRooms(): Array[Room] = {
    val xml = XML.loadFile("map.xml")
    ???
  }
}