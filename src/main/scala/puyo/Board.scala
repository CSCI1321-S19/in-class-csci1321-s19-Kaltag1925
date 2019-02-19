package puyo

class Board {
  private var _bobas = List.tabulate[Boba](6)(i => new Jelly(i, 11))
  private var _current = new Twoyo(new Puyo(2, -1, PuyoColor.random()), new Puyo(2, 0, PuyoColor.random()))
  private var _next = new Twoyo(new Puyo(6, 0, PuyoColor.random()), new Puyo(6, 1, PuyoColor.random()))

  def bobas = _bobas
  def current = _current
  def next = _next

  private val fallInterval = 1d
  private var fallDelay = 0d
  private val moveInterval = 0.1
  private var moveDelay = 0d

  def update(delay: Double): Unit = {
    moveDelay += delay
    if (moveDelay > moveInterval) {
      moveDelay = 0
      if (leftHeld) _current = _current.move(-1, 0)
      if (rightHeld) _current = _current.move(1, 0)
    }
    fallDelay += delay
    if (fallDelay > fallInterval) {
      _current = _current.move(0, -1)
      fallDelay = 0d
    }
  }

  //// Movement ////

  // Up //
  private var upHeld = false
  def upPressed(): Unit = upHeld = true
  def upReleased(): Unit = upHeld = false

  // Down //
  private var downHeld = false
  def downPressed(): Unit = downHeld = true
  def downReleased(): Unit = downHeld = false

  // Left //
  private var leftHeld = false
  def leftPressed(): Unit = leftHeld = true
  def leftReleased(): Unit = leftHeld = false

  // Right //
  private var rightHeld = false
  def rightPressed(): Unit = rightHeld = true
  def rightReleased(): Unit = rightHeld = false
}

object Board {
  val Width = 6
  val Height = 12
}