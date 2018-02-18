import sbt._

object Dependencies extends CucumberDependencies with TestDependencies with LoggingDependencies {
  def inCompile(modules: ModuleID*): Seq[ModuleID] = modules.map(_ % Compile)
}

trait CucumberDependencies {
  private[this] val cucumberScalaVersion = "2.0.1"
  private[this] val cucumberJvmVersion = "2.3.1"

  lazy val cucumberScala = "io.cucumber" %% "cucumber-scala" % cucumberScalaVersion
  lazy val cucumberJvm = "io.cucumber" % "cucumber-jvm" % cucumberJvmVersion
}

trait TestDependencies {
  private[this] val scalatestVersion = "3.0.5"
  private[this] val scalacheckVersion = "1.13.5"
  private[this] val seleniumVersion = "3.9.1"
  private[this] val pegdownVersion = "1.6.0"

  lazy val scalatest = "org.scalatest" %% "scalatest" % scalatestVersion
  lazy val scalacheck = "org.scalacheck" %% "scalacheck" % scalacheckVersion
  lazy val selenium = "org.seleniumhq.selenium" % "selenium-java" % seleniumVersion
  lazy val pegdown = "org.pegdown" % "pegdown" % pegdownVersion
}

trait LoggingDependencies {
  private[this] val scalaLoggingVersion = "3.7.2"
  private[this] val logbackVersion = "1.2.3"
  private[this] val groovyVersion = "2.4.13"

  lazy val logging = Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
    "ch.qos.logback" % "logback-classic" % logbackVersion,
    "org.codehaus.groovy" % "groovy" % groovyVersion
  )
}
