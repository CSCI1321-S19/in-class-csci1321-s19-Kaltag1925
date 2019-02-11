package basics

object Sorts extends App {
  def bubble(arr: Array[Int]): Unit = {
    for (i <- 0 until arr.length-1; j <- 0 until arr.length-1-i) {
      if (arr(j) > arr(j+1)) {
        val temp = arr(j)
        arr(j) = arr(j+1)
        arr(j+1) = temp
      }
    }
  }
  
  def bubble[A <% Ordered[A]](arr: Array[A]): Unit = {
    for (i <- 0 until arr.length-1; j <- 0 until arr.length-1-i) {
      if (arr(j) > arr(j+1)) {
        val temp = arr(j)
        arr(j) = arr(j+1)
        arr(j+1) = temp
      }
    }
  }
  
  def bubbleSort[A](arr: Array[A])(compare: (A, A) => Boolean): Unit = {
    for (i <- 0 until arr.length-1; j <- 0 until arr.length-1-i) {
      if (compare(arr(j), arr(j+1))) {
        val temp = arr(j)
        arr(j) = arr(j+1)
        arr(j+1) = temp
      }
    }
  }
  
  val nums = Array.fill(10)(util.Random.nextInt(100))
  println(nums.mkString(" "))
  bubbleSort(nums)(_ > _)
  println(nums.mkString(" "))
}