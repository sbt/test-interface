name := "test-interface"

organization := "org.scala-sbt"

version := "1.0"

description := "Uniform test interface to Scala/Java test frameworks (specs, ScalaCheck, ScalaTest, JUnit and other)"

scalaVersion := "2.13.15"

// disable using the Scala version in output paths and artifacts
crossPaths := false

autoScalaLibrary := false

publishTo := {
  val v = version.value
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("publish-snapshots" at nexus + "content/repositories/snapshots")
  else                             Some("publish-releases" at nexus + "service/local/staging/deploy/maven2")
}

libraryDependencies += "org.scalatest" %% "scalatest-refspec" % "3.2.19" % Test
libraryDependencies += "org.scalatest" %% "scalatest-shouldmatchers" % "3.2.19" % Test

publishMavenStyle := true

// Tests must be forked in this repo; otherwise the tests will use the classes from sbt.testing._
// provided by sbt rather than the ones compiled from these sources.
Test / fork := true

Test / publishArtifact := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://www.scala-sbt.org</url>
  <licenses>
    <license>
      <name>BSD</name>
      <url>https://github.com/sbt/test-interface/blob/master/LICENSE</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/sbt/test-interface</url>
  </scm>
  <developers>
    <developer>
      <id>harrah</id>
      <name>Mark Harrah</name>
    </developer>
    <developer>
      <id>josh</id>
      <name>Josh Cough</name>
    </developer>
    <developer>
      <id>bill</id>
      <name>Bill Venners</name>
    </developer>
    <developer>
      <id>cheeseng</id>
      <name>Chua Chee Seng</name>
    </developer>
  </developers>
)
