name := "simulant"

organization := "net._01001111"

version := "1.1"

scalaVersion := "2.10.0"

libraryDependencies += "org.specs2" % "specs2_2.10" % "2.0" % "test"

resolvers ++= Seq(
  "Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)
