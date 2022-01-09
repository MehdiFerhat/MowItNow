import org.scalatest.FunSuite
import Simulation.parseFile

class SimulationTest extends FunSuite {
  test("parsing test1") {
    val result = parseFile("src/test/resources/test1.txt")
    val sizeLawn = result._1
    val mowersAndInstructions = result._2

    assert(sizeLawn sameElements Array(5, 5))

    assert(mowersAndInstructions.length == 2)

    assert(mowersAndInstructions(0)._1.x == 1)
    assert(mowersAndInstructions(0)._1.y == 2)
    assert(mowersAndInstructions(0)._1.direction == 'N')

    assert(mowersAndInstructions(1)._1.x == 3)
    assert(mowersAndInstructions(1)._1.y == 3)
    assert(mowersAndInstructions(1)._1.direction == 'E')

  }

}
