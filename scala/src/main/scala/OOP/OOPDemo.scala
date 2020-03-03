package OOP

object OOPDemo {
  def main(args: Array[String]): Unit = {
    val cat = new Cat

//    cat.name = "布偶猫" // 底层 cat.name_$eq("布偶猫")
//    cat.age = 4 //... cat.age_$age(4)
//    cat.color = "黑" //...
//    val num: Int = cat.cal(2,3)
//
//    println("cat=" + cat)
//    println("cat的名字" + cat.name) //底层 cat.name()
//    println(num)

//    val exec = new MethodExec
//    //exec.PrintPicture()
//    val area: String = exec.GetArea()
//    println(area)
//    exec.NumCharge(3)

    val Ts:TicketSys = new TicketSys

    while(true){
      Ts.PrintSys(Ts.Test())
    }

    /**
      * 创建程序,在其中定义两个类：Account(银行账号)和AccountTest类体会Scala的封装性。
      * 1)	Account类要求具有属性：姓名（长度为2位- 4位）、余额(必须>20)、密码（必须是六位）
      * 2)	通过setXxx的方法给Account 的属性赋值。
      * 3)	完成转账的功能.
      * 4)	在AccountTest中测试
      *
      * 提示知识点：
      * var name : String = ""
      * var len = name.length() //按照字符的个数统计的
      */


  }

}
