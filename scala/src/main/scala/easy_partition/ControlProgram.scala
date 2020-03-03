package easy_partition

import scala.io.StdIn

object ControlProgram {
  def main(args: Array[String]): Unit = {
//    TestIf()
//    TestSumTwo()
//    TestIntTwo()
//    TestSuperYear()
//    TestGoods()
//    TestProbles()

    for(i <- 1 until 3) {
      print(i + " ")
    }

    //TestForNum()
    TestSuperOut()

  }

  //声明2个Int型变量并赋值。判断两数之和，如果大于等于50，打印“hello world!”
  def  TestIf(): Unit = {
    val a = 20
    val b = 13

    if(a+b > 30)
      println("hello world")
  }
  //编写程序，声明2个Double型变量并赋值。判断第一个数大于10.0，且第2个数小于20.0，打印两数之和。
  def TestSumTwo(): Unit ={
    val a = 12.4
    val b = 18.6

    if(a > 10.0){
      if(b < 20.0){
        println(a + b)
      }
    }
  }
  //定义两个变量Int，判断二者的和，是否既能被3又能被5整除，打印提示信息
  def TestIntTwo(): Unit = {
    val a = 12
    val b = 14

    if((a + b) / 3 == 0  && (a+b)/5 == 0){
      println("整除")
    }else{
      println("不能整除")
    }
  }
  //判断一个年份是否是闰年，闰年的条件是符合下面二者之一：(1)年份能被4整除，但不能被100整除；(2)能被400整除
  def TestSuperYear():Unit = {
    val year = 2000

    if(year%100 != 0){
      if(year%4 == 0){
        println("闰年")
      }
    }else{
      if(year%400 == 0){
        println("闰年")
      }
    }
  }

  /**
    * 岳小鹏参加scala考试，他和父亲岳不群达成承诺：
    * 如果：
    * 成绩为100分时，奖励一辆BMW；
    * 成绩为(80，99]时，奖励一台iphone7plus；
    * 当成绩为[60,80]时，奖励一个 iPad；
    * 其它时，什么奖励也没有。
    */
  def TestGoods():Unit = {
    val a = StdIn.readInt()

    if(a >= 100)
      println("BMW")
    if(a>80 && a<= 99)
      println("iphone7plus")
    if(a>= 60 && a<=80)
      println("ipad")
    if(a<60)
      println("nothing")
  }

  /**
    * 求ax^2+bx+c=0方程的根。a,b,c分别为函数的参数，如果：b^2-4ac>0，则有两个解；
    * b^2-4ac=0，则有一个解；b^2-4ac<0，则无解，结果保留小数点两位. [a=3 b=100 c=6]
    * 提示1：x1=(-b+sqrt(b^2-4ac))/2a
    * x2=(-b-sqrt(b^2-4ac))/2a
    * 提示2：sqrt(num)  在 scala 包中(默认引入的) 的math 的包对象有很多方法直接可用. math.sqrt()
    */
  def TestProbles():Unit = {
    val a = 1
    val b = 0
    val c = -4

    val flage = b * b - 4 * a * c

    if(flage>=0.0){
      println("有解")
      val x1: String = ((-b+math.sqrt(flage))/(2*a)).formatted("%.2f")
      val x2: String = ((-b-math.sqrt(flage))/(2*a)).formatted("%.2f")

      println(x1 +"..."+x2)
    }else{
      println("无解")
    }
  }

  //1) 打印1~100之间所有是9的倍数的整数的个数及总和.
  def TestForNum() :Unit ={

    var flag = 0
    for(i <- 1 to 100 if i%9 == 0){
      println(i)
      flag += 1
    }
    println(flag)
  }

  /**
    * 特殊输出
    */

  def TestSuperOut():Unit = {
    for (i <- 0 to 6 ){
      println(i+"+"+(6-i)+"="+6)
    }
  }

}
