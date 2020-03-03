package OOP

import scala.io.StdIn

class TicketSys {

  val All_Money = 20

  def  Test(): visitor ={
    println("性名")
    val name: String = StdIn.readLine()
    println("年龄")
    val age: Int = StdIn.readInt()

    val vs:visitor = new visitor
    vs.name = name
    vs.age = age

    return vs
  }

  def  PrintSys(vs:visitor): Unit ={
    if(vs.age>18){
      println(vs.name+"的年龄为："+vs.age+",门票价格："+ All_Money)
    }else
      println(vs.name+"的年龄为："+vs.age+",门票免费")
  }

}
