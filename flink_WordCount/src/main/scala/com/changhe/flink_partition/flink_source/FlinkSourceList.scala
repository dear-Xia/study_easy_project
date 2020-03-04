package com.changhe.flink_partition.flink_source

import org.apache.flink.streaming.api.scala._

object FlinkSourceList {
  def main(args: Array[String]): Unit = {
    //从集合（内存）中获取数据
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val lineDS = env.fromCollection(
      List(
        ("001", 1577844001L, 45),
        ("002", 1577844201L, 44),
        ("003", 1577844301L, 46)
      )
    )

    //使用map映射转换成样例类的格式
    val value: DataStream[WaterSensor] = lineDS.map {
      t => {
        WaterSensor(t._1, t._2, t._3)
      }
    }

    value.print("list")

    env.execute()
  }

}
