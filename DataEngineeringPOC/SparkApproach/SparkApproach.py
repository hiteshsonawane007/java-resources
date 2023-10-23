from pyspark.sql import SparkSession
import pandas as pd

if __name__ == '__main__':
    spark = SparkSession.builder.appName('TestApp').getOrCreate()
    print(spark)

    df = spark.read.format("csv").option("inferschema","true").option("header","true").option("delimiter",",").load("<<path for CSV file>>")
    df.printSchema()
    df.show()

    pandasdf = df.toPandas()