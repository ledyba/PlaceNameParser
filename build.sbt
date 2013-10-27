name := "Sample"
 
version := "1.0"
 
scalaVersion := "2.10.1"

resolvers ++= Seq(
	"snapshots"  at "http://oss.sonatype.org/content/repositories/snapshots",
	"staging"    at "http://oss.sonatype.org/content/repositories/staging",
	"releases"   at "http://oss.sonatype.org/content/repositories/releases",
	"typesafe-r" at "http://repo.typesafe.com/typesafe/releases"
)

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0.M8"

libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"

// Read here for optional dependencies:
// http://etorreborre.github.com/specs2/guide/org.specs2.guide.Runners.html#Dependencies

testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "sequential", "true")

testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "junitxml","html","console")

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "junitxml(directory=\"target/test-reports\")")
