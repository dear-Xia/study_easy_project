package com.changhe.wordcount

import org.apache.flink.streaming.api.scala._

object three {
  //无界流处理
  def main(args: Array[String]): Unit = {

    val environment: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    environment.setParallelism(2)

    //val lineDS: DataStream[String] = environment.readTextFile("input")
    //这里需要从网络中获取数据，用到了socket获取
    val lineDS: DataStream[String] = environment.socketTextStream("hadoop11",9999)

    val flateDS: DataStream[String] = lineDS.flatMap(_.split(" "))

    val mapDS: DataStream[(String, Int)] = flateDS.map((_,1))

    val groupDS: KeyedStream[(String, Int), String] = mapDS.keyBy(_._1)

    val sumDS: DataStream[(String, Int)] = groupDS.sum(1)

    //为了区分开打印效果，可以在print中增加打印前缀
    //因为DataStream都是可以打印的
    sumDS.print("sum = ")

    environment.execute()
  }

}
