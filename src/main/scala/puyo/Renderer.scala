package puyo

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

// TODO - Draw next Twoyo
class Renderer(gc: GraphicsContext) {
  import Renderer._
  import PuyoColor._
  def render(board: Board): Unit = {
    gc.fill = Color.DarkGreen
    gc.fillRect(0, 0, Main.canvasWidth, Main.canvasHeight)

    for (boba <- board.bobas) {
      drawBoba(boba)
    }

    //TODO - Draw currentdrawBoba
    
  }

  def drawBoba(boba: Boba): Unit = {
    gc.fill = boba.color match {
      case Red => Color.Red
      case Yellow => Color.Yellow
      case Blue => Color.Blue
      case Green => Color.Green
      case Magenta => Color.Magenta
      case Gray => Color.Grey
    }
    gc.fillOval(boba.x * CellSize, boba.y * CellSize, CellSize, CellSize)
  }
}

object Renderer {
  val CellSize = 30
}