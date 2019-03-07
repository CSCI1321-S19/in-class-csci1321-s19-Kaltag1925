package basics

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import javafx.scene.image.ImageView
import scalafx.Includes._
import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.scene.image.WritableImage
import scalafx.scene.paint.Color

class JuliaSet(c: Complex) {
  private var xmin = -1.5
  private var xmax = 1.5
  private var ymin = -1.5
  private var ymax = 1.5
  
  val maxCount = 10000
  def juliaCount(z0: Complex): Int = {
    var z = z0
    var cnt = 0
    while (cnt < maxCount && z.mag < 4) {
      z = z * z + c
      cnt += 1
    }
    cnt
  }

  def colorFromCount(cnt: Int): Color = {
    if (cnt == maxCount) Color.Black
    else Color(1.0, 0.0, 0.0, math.log(cnt + 1) / math.log(maxCount))
  }
  
  def pixelToX(i: Double, img: WritableImage): Double = xmin + i * (xmax - xmin) / img.width()
  def pixelToY(j: Double, img: WritableImage): Double = ymin + j * (ymax - ymin) / img.height()
  
  def drawJulia(img: WritableImage): Unit = {
    val writer = img.pixelWriter
    val start = System.nanoTime()
		val colors = for (j <- 0 until img.height().toInt) yield Future {
      val y = pixelToY(j, img)
      for (i <- 0 until img.width().toInt) yield {
        val x = pixelToX(i, img)
        val cnt = juliaCount(new Complex(x, y))
        (j, i, colorFromCount(cnt))
      }
    }
    
    val drawnFuture = for (futureRow <- colors) yield {
      futureRow.map {
        case seq => 
          Platform.runLater(for((j, i, color) <- seq) {
            writer.setColor(i, j, color)
          })
      }
    }
    val singleFuture = Future.sequence(drawnFuture)
    println("Took " + ((System.nanoTime() - start) * 1e-9) + " seconds.")
  }

  val stage = new scalafx.stage.Stage {
    title = "Julia for "+c.x+", "+c.y
    scene = new Scene(1000, 1000) {
      val img = new WritableImage(1000, 1000)
      val imgView = new ImageView(img)
      content = imgView
      drawJulia(img)
    }
  }
  stage.show()
}
