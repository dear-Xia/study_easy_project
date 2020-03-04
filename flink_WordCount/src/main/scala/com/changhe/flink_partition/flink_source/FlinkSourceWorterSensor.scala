package com.changhe.flink_partition.flink_source

import org.apache.flink.api.scala._

object FlinkSourceWorterSensor {
  def main(args: Array[String]): Unit = {
    //模拟水位传感器
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment

    //读取集合中的数据--样例类
    val linrDS: DataSet[WaterSensor] = env.fromCollection(
      List(
        WaterSensor("001", 1577844001L, 45),
        WaterSensor("002", 1577844301L, 44),
        WaterSensor("003", 1577844041L, 46)
      )
    )
    linrDS.print("waterSensor")

    env.execute()

  }

}

case class WaterSensor(id: String, ts: Long , vc : Double)
