package com.changhe.flink_partition.flink_source

import org.apache.flink.streaming.api.functions.source.SourceFunction
import org.apache.flink.streaming.api.scala._

import scala.util.Random

object FlinkSourceDIY {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment
      .getExecutionEnvironment

    //自定义数据源
    val MyDS: DataStream[WaterSensor] = env.addSource(new MySource())

    MyDS.print("my")

    env.execute()
  }

 class MySource extends SourceFunction[WaterSensor]{

   var flage = true

   //运行
   override def run(sourceContext: SourceFunction.SourceContext[WaterSensor]): Unit = {

     while (flage){
       //"003",1577844301,46，生产数据
       val sensor = WaterSensor("003"+ new Random().nextInt(10),1577844301,(11+ new Random().nextInt(20)))

       //采集数据，将数据放入flink
       sourceContext.collect(sensor)

       //;休眠
       Thread.sleep(500)
     }
   }

   //结束
   override def cancel(): Unit = {
     flage = false
   }
 }

}
