package easy_partition

object TurnType {
  def main(args: Array[String]): Unit = {
    //自动类型转换
    val a = 'a'

    val b : Short = 2

    val c = a + b

    println(c)
    //强制类型转换
    val d = 12
    val f = 12.234
    val e = d.toString
    val g = f.toInt
    println(e)
    println(g)
    //string类型于数字转化
    //s1.toInt、s1.toFloat、s1.toDouble、s1.toByte、s1.toLong、s1.toShort,转化基本数据类型

    val h = "123"
    val i = h.toInt
    println(i)

  }

}
