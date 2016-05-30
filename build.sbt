import com.typesafe.config.ConfigFactory

name := """spark-timeseries"""

val conf = ConfigFactory.parseFile(new File("build.conf")).resolve()

version := conf.getString("build.version")

scalaVersion := conf.getString("build.scala.version")

lazy val nexus = conf.getString("build.nexus.url")

lazy val akkaVersion = conf.getString("build.akka.version")

lazy val sparkVersion = conf.getString("build.spark.version")

val releaseUrl = "releases" at s"$nexus/releases"

val snapshotUrl = "snapshots" at s"$nexus/snapshots"

publishTo := {
  if (isSnapshot.value) Some(snapshotUrl) else Some(releaseUrl)
}

organization := "com.cloudera.sparkts"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.apache.velocity" % "velocity" % "1.7"
libraryDependencies += "org.apache.hadoop" % "hadoop-yarn-client" % "2.6.0"
libraryDependencies += "org.scala-lang" % "scala-library" % "2.11.8"
libraryDependencies += "org.scala-lang" % "scalap" % "2.11.8"
libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.11.8"
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-catalyst" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-mllib" % sparkVersion
libraryDependencies += "org.threeten" % "threeten-extra" % "0.9"
libraryDependencies += "org.scalanlp" %% "breeze" % "0.11.2"
libraryDependencies += "org.scalanlp" %% "breeze-viz" % "0.11.2"
libraryDependencies += "org.apache.commons" % "commons-math3" % "3.4.1"
libraryDependencies += "junit" % "junit" % "4.12"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

