package com.changhe.windowsAPI

import org.apache.flink.shaded.netty4.io.netty.handler.codec.http2.Http2Exception.StreamException
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment, _}
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow

/**
  * 滚动窗口
  */
object FlinkTimeWindows {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    env.setParallelism(1)

    val TxDS: DataStream[String] = env.socketTextStream("hadoop11",9999)

    //分流
    val MapDS: DataStream[(String, Int)] = TxDS.map((_,1))

    val KeyDS: KeyedStream[(String, Int), String] = MapDS.keyBy(_._1)

    //对分流后的数据开窗
    val WindowsDS: WindowedStream[(String, Int), String, TimeWindow] = KeyDS.timeWindow(Time.seconds(5))

    val ReduceDS: DataStream[(String, Int)] = WindowsDS.reduce {
      (a, b) => {
        (a._1, a._2 + b._2)
      }
    }
    ReduceDS.print("窗口")

    env.execute()


  }

}
