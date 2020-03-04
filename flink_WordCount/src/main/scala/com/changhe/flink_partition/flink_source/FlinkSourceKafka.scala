package com.changhe.flink_partition.flink_source

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011

object FlinkSourceKafka {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment
      .getExecutionEnvironment

    //flink没有提供kafka的数据源采集功能
    //需要自己手动添加相关依赖
    //并且需要让flink可以支持kafka操作，增加数据源

    val topic = "sensor"
    val properties = new Properties()
    properties.setProperty("bootstrap.servers", "hadoop11:9092")
    properties.setProperty("group.id", "consumer-group")
    properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    properties.setProperty("auto.offset.reset", "latest")

    val KafkaDS: DataStream[String] = env.addSource(new FlinkKafkaConsumer011[String](topic, new SimpleStringSchema(),properties))

    KafkaDS.map{
      t => {
        val data: Array[String] = t.split(",")
        WaterSensor(data(0),data(1).toLong,data(2).toInt)
      }
    }.print("kafka")

    env.execute()
  }

}
