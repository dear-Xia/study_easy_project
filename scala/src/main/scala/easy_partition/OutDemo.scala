package easy_partition

object OutDemo {
  def main(args: Array[String]): Unit = {

    val  name = "xiaohong"

    val age  = 18

    var money : Double = 1982.456

    /**   %s:代表字符串
      *   %d：代表数字
      *   %.2f： 代表浮点数
      */
    printf("name  =  %s , age = %d , money = %.2f",name,age, money)

    /**
      * string "$变量名"，可以用来获取值
      * age = ${age+1}，直接计算
      *  money = ${money.formatted("%.2f")}， double.formated(""):保留小数点，返回值是string类型
      */
    println(s"name = $name, age = ${age+1} , money = ${money.formatted("%.2f")}")

    println(money)

  }

}
