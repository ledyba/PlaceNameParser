resolvers += Classpaths.typesafeResolver
 
resolvers ++= Seq(
	"snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
	"typesafe" at "http://repo.typesafe.com/typesafe/releases" 
)

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "latest.integration")
 
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.2")
