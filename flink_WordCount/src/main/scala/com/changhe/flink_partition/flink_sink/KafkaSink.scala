package com.changhe.flink_partition.flink_sink

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.datastream.DataStreamSink
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kafka.{FlinkKafkaConsumer011, FlinkKafkaProducer011}

object KafkaSink {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    //向kafka传递数据，通过kafka消费者消费数据
    val ListDS: DataStream[String] = env.fromCollection(
      List("a", "b", "c", "d")
    )
    val KafkaSinkC: DataStreamSink[String] = ListDS.addSink(new FlinkKafkaProducer011[String]("hadoop11:9092", "sensor", new SimpleStringSchema()))


    env.execute()
  }

}
