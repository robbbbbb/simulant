import sbt._

class SimulantProject(info: ProjectInfo) extends DefaultProject(info) {

  lazy val specs2 = "org.specs2" %% "specs2" % "1.3" % "test"

  def specs2Framework = new TestFramework("org.specs2.runner.SpecsFramework")
  override def testFrameworks = super.testFrameworks ++ Seq(specs2Framework)

  lazy val releases  = "releases" at "http://scala-tools.org/repo-releases"
  lazy val snapshots = "snapshots" at "http://scala-tools.org/repo-snapshots"
}