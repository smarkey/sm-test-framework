package com.stevenm.state

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

private class TestState {
  private lazy val webDriver = new ChromeDriver()
}

object TestState {
  private[this] var state = new TestState

  def webDriver: WebDriver = state.webDriver

  def reset(): Unit = state = {
    webDriver.close()
    webDriver.quit()
    new TestState
  }
}
