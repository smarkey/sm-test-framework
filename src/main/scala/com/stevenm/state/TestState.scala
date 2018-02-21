package com.stevenm.state

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}

import scala.util.Properties

private class TestState {
  private val options = {
    val chromeOptions = new ChromeOptions()
    val browser = Properties.propOrElse("browser", "chrome")

    if(browser == "chrome-headless") { chromeOptions.addArguments("headless") }

    chromeOptions.addArguments("window-size=1920,1080")
    chromeOptions
  }

  private lazy val webDriver = new ChromeDriver(options)
}

object TestState {
  private[this] var state = new TestState

  def webDriver: WebDriver = state.webDriver

  def reset(): Unit = {
    webDriver.close()
    webDriver.quit()
    state = new TestState
  }
}
