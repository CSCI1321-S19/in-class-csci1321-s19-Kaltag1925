package puyo

import scalafx.application.JFXApp
import scalafx.scene.canvas.Canvas
import scalafx.scene.Scene
import scalafx.animation.AnimationTimer
import scalafx.scene.input.KeyCode
import scalafx.scene.input.KeyEvent
import scalafx.Includes._


object Main extends JFXApp {
  val canvasWidth = 6 * Renderer.CellSize
  val canvasHeight = 12 * Renderer.CellSize
  stage = new JFXApp.PrimaryStage {
    title = "Puyo"
    scene = new Scene(canvasWidth, canvasHeight) {
      val canvas = new Canvas(canvasWidth, canvasHeight)
      val gc = canvas.graphicsContext2D
      val renderer = new Renderer(gc)
      val board = new Board

      content = canvas

      canvas.onKeyPressed = (ke: KeyEvent) => {
		    ke.code match {
		      case KeyCode.Up => board.upPressed()
		      case KeyCode.Down => board.downPressed()
		      case KeyCode.Left => board.leftPressed()
		      case KeyCode.Right => board.rightPressed()
		      case _ =>
		    }
		  }
		  
		  canvas.onKeyReleased = (ke: KeyEvent) => {
		    ke.code match {
		      case KeyCode.Up => board.upReleased()
		      case KeyCode.Down => board.downReleased()
		      case KeyCode.Left => board.leftReleased()
		      case KeyCode.Right => board.rightReleased()
		      case _ =>
		    }
		  }
      
      var lastTime = -1L
      val timer = AnimationTimer(time => {
        if (lastTime != -1) {
          val delay = (time-lastTime)/1E9
          board.update(delay)
          renderer.render(board)
        }
        lastTime = time
      })
      timer.start()

      renderer.render(board)
    }
  }
}