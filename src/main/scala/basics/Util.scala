package basics

object Util extends App {
  def findAndRemove[A](lst: List[A])(pred: A => Boolean): (Option[A], List[A]) = {
    lst match {
      case Nil => (None, lst)
      case h::t => 
        if (pred(h)) (Some(h), t) else {
         val (found, fixedList) = findAndRemove(t)(pred)
         (found, h :: fixedList)
        }
    }
  }
  
  val nums = List(1, 2, 3, 4, 5)
  val (five, notFive) = findAndRemove(nums)(_ == 5)
  println(five, notFive)
}