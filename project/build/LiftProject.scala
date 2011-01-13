import sbt._

class LiftProject(info: ProjectInfo) extends DefaultWebProject(info) {


  //override def scanDirectories = Nil

  val liftVersion = "2.2-RC5"
  

  val mysqlver = "mysql" % "mysql-connector-java" % "5.1.13" from 
  "http://mirrors.ibiblio.org/pub/mirrors/maven2/mysql/mysql-connector-java/5.1.13/mysql-connector-java-5.1.13.jar"
  
  val scalaToolsSnapshots = "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots" 

  
  override def libraryDependencies = Set(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-widgets" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-ldap" % liftVersion % "compile->default",
    "org.mortbay.jetty" % "jetty" % "6.1.22" % "test->default",
    "junit" % "junit" % "4.5" % "test->default",
    "org.mockito" % "mockito-core" % "1.8.5" % "test->default",
    "org.scala-tools.testing" %% "specs" % "1.6.6" % "test->default",
    "com.h2database" % "h2" % "1.2.138",
    "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default"
  ) ++ super.libraryDependencies
}
