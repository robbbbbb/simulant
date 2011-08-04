name := "simulant"

organization := "net._01001111"

version := "1.1"

crossScalaVersions := Seq("2.8.1", "2.9.0")

libraryDependencies += "org.specs2" %% "specs2" % "1.3" % "test"

resolvers ++= Seq(
  "releases" at "http://scala-tools.org/repo-releases",
  "snapshots" at "http://scala-tools.org/repo-snapshots"
)