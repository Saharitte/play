import play.Project._

name := "query-project"

version := "1.0"

libraryDependencies ++= Seq(
  javaJdbc, 
  javaJpa, 
  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
"com.datastax.cassandra" % "cassandra-driver-core" % "2.1.7.1",
"mysql" % "mysql-connector-java" % "5.1.18",
 "org.apache.spark" % "spark-core_2.10" % "1.4.1",
    "org.apache.spark" % "spark-streaming_2.10" % "1.4.1",
    "org.apache.spark" % "spark-mllib_2.10" % "1.4.1",
    "org.apache.hadoop" % "hadoop-client" % "2.6.0",
    "org.apache.spark" % "spark-streaming_2.10" % "1.4.1",
    "com.datastax.spark" % "spark-cassandra-connector-java_2.10" % "1.4.0-M1",
    "com.datastax.spark" % "spark-cassandra-connector_2.10" % "1.4.0-M1")

playJavaSettings
