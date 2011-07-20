name := "simulant"

version := "1.0"

crossScalaVersions := Seq("2.8.1", "2.9.0")

libraryDependencies += "org.specs2" %% "specs2" % "1.3" % "test"

resolvers ++= Seq(
  "releases" at "http://scala-tools.org/repo-releases",
  "snapshots" at "http://scala-tools.org/repo-snapshots"
)