package com.changhe.flink_partition.flink_source

import org.apache.flink.streaming.api.scala._

object FlinkSourceFile {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    //从文件中读取，并将数据保存到样例类中
    val ReadDS: DataStream[String] = env.readTextFile("input/data.txt")

    ReadDS.map{
      t =>{
        val data: Array[String] = t.split(",")
        WaterSensor(data(0).toString,data(1).toLong,data(2).toInt)
      }
    }print("text")

    env.execute()
  }

}
