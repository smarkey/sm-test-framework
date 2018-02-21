package com.stevenm.hooks

import java.nio.file.{Files, Paths}

import com.stevenm.state.TestState
import com.stevenm.utils.SeleniumCucumberTest
import org.openqa.selenium.WebDriver

import scala.util.Properties

class Hooks extends SeleniumCucumberTest {

  private[this] lazy val screenshotDir = Files.createDirectories(Paths.get(Properties.propOrElse("screenshot.dir", "screenshots"))).toFile.getAbsolutePath

  Before(10) { _ =>
    TestState.reset()
  }

  After(Int.MaxValue) {
    scenario => {
      if (scenario.isFailed) {
        import org.scalatest.selenium.WebBrowser._
        implicit lazy val webDriver: WebDriver = TestState.webDriver
        setCaptureDir(screenshotDir)
        captureTo(s"${scenario.getName}.png")
      }
    }
  }

  scala.sys.addShutdownHook {
    val webDriver: WebDriver = TestState.webDriver
    webDriver.close()
    webDriver.quit()
  }
}
