package com.changhe.wordcount

import org.apache.flink.api.scala._

//有节流或者批处理
object Onetest {
  def main(args: Array[String]): Unit = {
   //获取执行环境
   val environment: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
  //读取数据，这里是读取相对主项目文件架的数据
   val lineDS: DataSet[String] = environment.readTextFile("input")
  //将数据扁平化：flatmap
   val flateDS: DataSet[String] = lineDS.flatMap(_.split(" "))
   //将数据转换结构
   val mapDS: DataSet[(String, Int)] = flateDS.map((_,1))
   //分组聚合
   //val groupDS: GroupedDataSet[(String, Int)] = mapDS.groupBy(_._1)
   val groupDS: GroupedDataSet[(String, Int)] = mapDS.groupBy(0)
    //聚合
    //Aggregate does not support grouping with KeySelector functions, yet.
    //原因是不支持关键词选择器的分组，所以问题出在分组上，换程按照位置分组即可
    val sumDS: AggregateDataSet[(String, Int)] = groupDS.sum(1)

    //打印
    sumDS.print()

  }

}
