name := "ScalaWorkshopSolutions"

version := "1.0"

scalaVersion := "2.11.8"

resolvers ++= Seq("Local Maven Repository" at "file:///"+Path.userHome+"/.m2/repository",
        "Signpost releases" at "https://oss.sonatype.org/content/repositories/signpost-releases/")

libraryDependencies ++= Seq("joda-time" % "joda-time" % "1.6",
        "org.scalatest" %% "scalatest" % "2.2.0" % "test",
        "org.specs2" %% "specs2" % "2.3.12" % "test",
	"org.json4s" %% "json4s-native" % "3.2.9",
        "junit" % "junit" % "4.7" % "test")

EclipseKeys.withSource := true
