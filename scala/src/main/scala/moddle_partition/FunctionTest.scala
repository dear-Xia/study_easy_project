package moddle_partition

import scala.io.StdIn

object FunctionTest {
  def main(args: Array[String]): Unit = {

    val num: Int = StdIn.readInt()
    f4(num)
    f5(num)

  }

  //形式1
  def f1(): Int = {
    100
  }

  //形式2,保留了=，这里不要有return语句，因为不生效
  def f2(n1:Int,n2:Int) = {
    if(n1 > n2){
      n1+n2
    }else{
      "error"
    }
  }

  //形式3，如果没有返回值，可以省略： 类型=，这样有return也不会有返回值
  def f3(): Unit ={
    println("ok")
  }

  //1)	函数/方法可以没有返回值案例，编写一个函数,从终端输入一个整数打印出对应的金子塔
  def  f4(num : Int){
    for (i <- 1  to num){
      println("*"*(2*i-1))
    }
  }

  //2)	编写一个函数/方法,从终端输入一个整数(1—9),打印出对应的乘法表
  def  f5(num : Int): Unit ={
    if(num > 9 && num <1){
      println("输入数据有误")
    }else{
      for (i <- 1 to num ){
        for (j <- 1 to num if i>= j){
          print(i +"*"+j+"="+(i*j) +" ")
        }
        println()
      }
    }
  }

  //3)	编写函数,对给定的一个二维数组(3×3)转置

}

