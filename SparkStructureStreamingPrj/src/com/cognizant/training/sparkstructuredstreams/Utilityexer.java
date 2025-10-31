package com.cognizant.training.sparkstructuredstreams;

import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class Utilityexer {
        
        public static StructType custSchema() {
                StructField idField = DataTypes.createStructField("custId", DataTypes.IntegerType, false);
                StructField nameField = DataTypes.createStructField("custname", DataTypes.StringType, false);
                StructField email = DataTypes.createStructField("email", DataTypes.StringType, false);
                StructType custSchema=new StructType(new StructField[] {idField,nameField,email});
                return custSchema;
        }

}