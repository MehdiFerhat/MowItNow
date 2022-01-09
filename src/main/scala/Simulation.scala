
import scala.io.Source
import java.io.File

object Simulation {

  def parseFile(path: String): (Array[Int],List[(Mower,String)]) = {
    val input = Source.fromFile(path).getLines().toList
    if(input.isEmpty) throw new Exception("Error")
    val sizeLawn = input.head.split(" ").map(_.toInt)
    val mowerAndInstructions = input.tail.zipWithIndex
    val mowerCoords = mowerAndInstructions.filter(_._2 % 2 == 0).map(_._1)
    val instructions = mowerAndInstructions.filter(_._2 % 2 == 1).map(_._1)
    val mowers = mowerCoords.map(mowerConf => {
      val mowerCoord = mowerConf.split(" ")
      new Mower(mowerCoord(0).toInt, mowerCoord(1).toInt, mowerCoord(2).head)
    })
    val output = mowers zip instructions
    (sizeLawn, output)
  }


  def main(args: Array[String]): Unit = {
    val parsedFile= parseFile(args(0))
    val size = parsedFile._1
    val mowersAndInstructions: Seq[(Mower, String)] = parsedFile._2
    var i = 1
    mowersAndInstructions.foreach(mowerAndInstruction => {
      val mower = mowerAndInstruction._1
      val instruction = mowerAndInstruction._2

      instruction.foreach(mower.move(_, size(0), size(1)))
      println("Tondeuse " + i +" : " +mower.getPosition())
      i += 1
    })
  }
}
