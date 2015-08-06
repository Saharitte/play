import play.Project._

name := "query-project"

version := "1.0"

libraryDependencies ++= Seq(
  javaJdbc, 
  javaJpa, 
  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
"mysql" % "mysql-connector-java" % "5.1.18"
  )

playJavaSettings
