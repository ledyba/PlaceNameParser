name := "Sample"
 
version := "1.0"
 
scalaVersion := "2.10.1"

resolvers ++= Seq(
	"snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
	"typesafe" at "http://repo.typesafe.com/typesafe/releases" 
)

libraryDependencies += "org.scalatest" % "scalatest_2.10.0-M4" % "1.9-2.10.0-M4-B1"

libraryDependencies += "com.novocode" % "junit-interface" % "0.10"

// Read here for optional dependencies:
// http://etorreborre.github.com/specs2/guide/org.specs2.guide.Runners.html#Dependencies
 
testOptions in Test += Tests.Argument("junitxml", "html", "console")
 

