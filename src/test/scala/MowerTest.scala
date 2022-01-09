import org.scalatest.FunSuite

class MowerTest extends FunSuite {
  test("rotating D from E should return S") {
    val mower = new Mower(0, 0, 'E')
    mower.rotate(1)

    assert(mower.direction == 'S')
  }

  test("rotating G from E should return S") {
    val mower = new Mower(0, 0, 'E')
    mower.rotate(-1)

    assert(mower.direction == 'N')
  }

  test("Full rotation D") {
    val mower = new Mower(0, 0, 'E')

    mower.rotate(1)
    assert(mower.direction == 'S')

    mower.rotate(1)
    assert(mower.direction == 'W')

    mower.rotate(1)
    assert(mower.direction == 'N')

    mower.rotate(1)
    assert(mower.direction == 'E')
  }

  test("Full rotation G") {
    val mower = new Mower(0, 0, 'E')

    mower.rotate(-1)
    assert(mower.direction == 'N')

    mower.rotate(-1)
    assert(mower.direction == 'W')

    mower.rotate(-1)
    assert(mower.direction == 'S')

    mower.rotate(-1)
    assert(mower.direction == 'E')
  }
}
