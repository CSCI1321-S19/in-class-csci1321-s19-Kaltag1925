package polymorphism

object SampleCode {
  def square(x: Double) = x*x
  
  def sumValues(n: Int): Double = {
    if (n < 1) 0.0 else readDouble() + sumValues(n - 1)
  }
  
  def productValues(n: Int): Double = {
    if (n < 1) 1.0 else readDouble() * sumValues(n - 1)
  }
  
  def combineValues(n: Int, base: Double, op: (Double, Double) => Double): Double = {
    if (n < 1) base else op(readDouble(), combineValues(n - 1, base, op))
  }
  
  def bubbleSort[A <% Ordered[A]](arr: Array[A]): Unit = {
    for (i <- 0 until arr.length -1; j <- 0 until arr.length-1-i) {
      if (arr(j+1) < arr(j)) {
        val temp = arr(j)
        arr(j) = arr(j+1)
        arr(j+1) = temp
      }
    }
  }
  
  def bubbleSortComp[A](arr: Array[A])(lt: (A, A) => Boolean): Unit = {
    for (i <- 0 until arr.length -1; j <- 0 until arr.length-1-i) {
      if (lt(arr(j+1), arr(j))) {
        val temp = arr(j)
        arr(j) = arr(j+1)
        arr(j+1) = temp
      }
    }
  }
}