package easy_partition

import scala.io.StdIn

/**
  * 键盘输入：
  * StdIn.readLine()、
  * StdIn.readInt()、
  * StdIn.readDouble()
  */
object InputDemo {
  def main(args: Array[String]): Unit = {
    var name: String = StdIn.readLine()

    val age: Int = StdIn.readInt()

    val money: Double = StdIn.readDouble()

    println(s"name = $name, age = $age , money = $money")
  }

}
