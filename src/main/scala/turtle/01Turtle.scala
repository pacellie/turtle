package turtle

object turtle01 extends App {

  /**
   *
   * Advantages:
   *  + Easy to implement and understand.
   *
   * Disadvantages:
   *  - Stateful code is hard to test.
   *  - Client is coupled to a particular implementation.
   *
   **/

  import common.{move => cmove, _}

  class Turtle(log: Log) {

    var position = initial.position
    var angle    = 0.0
    var color    = initial.color
    var pen      = initial.pen

    def move(distance: Distance): Unit = {
      log(f"Move $distance%.1f")

      val position = cmove(distance, this.angle, this.position)

      if (this.pen == Down) {
        drawLine(log, this.position, position, this.color)
      }

      this.position = position
    }

    def turn(angle: Angle): Unit = {
      log(f"Turn $angle%.1f")

      this.angle = (this.angle + angle) % 360.0
    }

    def penUp(): Unit = {
      log("Pen up")

      this.pen = Up
    }

    def penDown(): Unit = {
      log("Pen down")

      this.pen = Down
    }

    def setColor(color: Color): Unit = {
      log(s"Set color to ${color.toString.toLowerCase()}")

      this.color = color
    }

  }

  def drawTriangle(): Unit = {
    val turtle = new Turtle(println)

    turtle.move(100.0)
    turtle.turn(120.0)

    turtle.move(100.0)
    turtle.turn(120.0)

    turtle.move(100.0)
    turtle.turn(120.0)
  }

  drawTriangle()

}