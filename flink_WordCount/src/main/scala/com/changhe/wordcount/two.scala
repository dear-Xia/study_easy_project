package com.changhe.wordcount

import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.{DataStream, KeyedStream, StreamExecutionEnvironment}

//这里采用流处理，上一个是数据集
object two {
  def main(args: Array[String]): Unit = {
    //获取执行环境
    val environment: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    //设置并行度
    environment.setParallelism(4)
    //读取数据，这里是读取相对主项目文件架的数据
    val lineDS: DataStream[String] = environment.readTextFile("input")
    //将数据扁平化：flatmap
    val flateDS: DataStream[String] = lineDS.flatMap(_.split(" "))
    //将数据转换结构
    val mapDS: DataStream[(String, Int)] = flateDS.map((_,1))
    //分组聚合
    //val groupDS: GroupedDataSet[(String, Int)] = mapDS.groupBy(_._1)
    val groupDS: KeyedStream[(String, Int), String] = mapDS.keyBy(_._1)
    //聚合
    //Aggregate does not support grouping with KeySelector functions, yet.
    //原因是不支持关键词选择器的分组，所以问题出在分组上，换程按照位置分组即可
    val sumDS: DataStream[(String, Int)] = groupDS.sum(1)

    //打印
    sumDS.print()

    //这里是因为流处理框架没有动起来,才能动态的接收数据
    //flink是一个事件驱动的流处理框架
    environment.execute()

  }

}
