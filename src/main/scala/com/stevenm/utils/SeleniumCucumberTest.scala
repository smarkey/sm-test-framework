package com.stevenm.utils

import com.stevenm.state.TestState
import com.typesafe.scalalogging.{LazyLogging, Logger}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebDriver
import org.scalatest.Matchers
import org.scalatest.concurrent.{Eventually, PatienceConfiguration}
import org.scalatest.selenium.WebBrowser

import scala.concurrent.duration._
import scala.language.postfixOps

class SeleniumCucumberTest extends ScalaDsl with EN with Matchers with Eventually with LazyLogging with WebBrowser with PatienceConfiguration {
  self: LazyLogging =>

  implicit lazy val log: Logger = logger

  implicit def webDriver: WebDriver = TestState.webDriver

  val timeout: FiniteDuration = 5 seconds

  val interval: FiniteDuration = 0.5 seconds
}
