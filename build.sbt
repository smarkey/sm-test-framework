import Dependencies._

organization := "com.stevenmarkey"
name := "sm-test-framework"
version := "0.1"

scalaVersion := "2.12.4"
scalacOptions ++= List("-feature", "-deprecation", "-unchecked", "-Xlint")

lazy val uiDependencies = logging ++ inCompile(cucumberJvm, cucumberScala, scalatest, selenium, pegdown)

libraryDependencies ++= uiDependencies
mainClass in(Compile, run) := Some("cucumber.api.cli.Main")
trapExit in(Compile, run) := false

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")