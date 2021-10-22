import pandas as pd

df = spark.read.format("csv").option("inferschema","true").option("header","true").option("delimiter",",").load("<<S3_path for CSV file>>")
df.printSchema()
df.show()

pandasdf = df.toPandas()