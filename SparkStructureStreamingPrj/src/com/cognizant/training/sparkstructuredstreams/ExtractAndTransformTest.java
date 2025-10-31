package com.cognizant.training.sparkstructuredstreams;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.Trigger;

public class ExtractAndTransformTest {
public static void main(String[] args) {
        SparkSession spark=SparkSession.builder().appName("data-set-test-app")
                                                .master("local[*]").getOrCreate();
        spark.sparkContext().setLogLevel("WARN");
        Dataset<Row> dataset1=spark.readStream().schema(Utility.employeeSchema())
                                        .csv("C:/structuredstreaminput/test").where("designation='Developer'");
        try {
                StreamingQuery streamingQuery=dataset1.writeStream()
                                .trigger(Trigger.ProcessingTime(30,TimeUnit.SECONDS))
                                .format("console").start();
                System.out.println("streaming started");
                Thread.sleep(10*60*1000);
                streamingQuery.stop();
        } catch (TimeoutException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
}
}
