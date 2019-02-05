package puyo

object PuyoColor extends Enumeration {
  val Red, Yellow, Blue, Green, Magenta, Gray = Value
  
  val puyoColors = (values - Gray).toSeq
  
  def random(): Value = {
    values.toSeq(util.Random.nextInt(5))
  }
}