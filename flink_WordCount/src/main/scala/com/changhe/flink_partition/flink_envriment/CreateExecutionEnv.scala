package com.changhe.flink_partition.flink_envriment

import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

object CreateExecutionEnv {
  def main(args: Array[String]): Unit = {
    //批处理环境
    val DSEnv: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment

    //流式处理环境
    val StEnv: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    //返回本地执行环境，需要指明默认的并行度
    val LocalEnv: StreamExecutionEnvironment = StreamExecutionEnvironment.createLocalEnvironment(1)

    //返回集群执行环境,需要再执行的端口和ip，以及指定的jar包下运行
    val environment: ExecutionEnvironment = ExecutionEnvironment.createRemoteEnvironment("hostname",6123,"/opt/mpdule/jars/wc.jar")

    //解释：上两种和下两种相比较，更加简单，因为获取的源码中，会自动去加载和调用创建的方法，只要满足创建条件
  }

}
