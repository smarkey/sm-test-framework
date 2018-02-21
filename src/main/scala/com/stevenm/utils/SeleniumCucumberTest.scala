package com.stevenm.utils

import com.stevenm.state.TestState
import com.typesafe.scalalogging.LazyLogging
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebDriver
import org.scalatest.Matchers
import org.scalatest.concurrent.{Eventually, PatienceConfiguration}

import scala.concurrent.duration._
import scala.language.postfixOps

trait SeleniumCucumberTest extends ScalaDsl with EN with Matchers with Eventually with LazyLogging with PatienceConfiguration {
  self: LazyLogging =>

  implicit def webDriver: WebDriver = TestState.webDriver

  implicit val timeout: FiniteDuration = 5 seconds

  implicit val interval: FiniteDuration = 0.5 seconds
}
