package OOP

/**
  * 1)	编写类(MethodExec)，编程一个方法，
  * 方法不需要参数，在方法中打印一个
  * 10*8 的矩形，在main方法中调用该方法
  */
class MethodExec {

  def  PrintPicture(): Unit ={
    for (i<- 1 to 10 ){
      for(j<- 1 to 8 ){
        print("*")
      }
      println()
    }
  }

  /**
    * 编写一个方法中，方法不需要参数，计算该矩形的面积，
    * 并将其作为方法返回值。在main方法中调用该方法，
    * 接收返回的面积值并打印(结果保留小数点2位)
    */
  def GetArea(): String ={
    val n1 : Double = 2.2
    val n2 : Double = 3.312

    return (n1*n2).formatted("%.2f")
  }

  /**
    * 判断一个数是奇数odd还是偶数
    */
  def  NumCharge(n1:Int): Unit ={
    if(n1%2 == 0){
      println("偶数")
    }else
      println("奇数")
  }
}
