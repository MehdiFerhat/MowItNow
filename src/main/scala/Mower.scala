class Mower(var x: Int, var y: Int , var direction : Char) {

  val cardinalPoints: String = "NESW"

  def getPosition(): String = s"${x} ${y} ${direction}"

  def rotate (sens: Int): Unit = {
    direction = cardinalPoints.charAt((cardinalPoints.indexOf(direction) + sens + 4) % 4)
  }

  def move(letter: Char, size_n : Int, size_p : Int): Unit = {
    letter match {
      case 'G' => rotate(-1)
      case 'D' => rotate(1)
      case 'A' => {
        direction match {
          case 'E' =>
            if (x < size_n) x = x + 1
          case 'W' =>
            if (x > 0) x = x -1
          case 'N' =>
            if (y < size_p) y = y + 1
          case 'S' =>
            if (y > 0) y = y - 1
        }
      }
      case _ => {
        throw new Exception("Wrong expression")
      }
    }
  }

}