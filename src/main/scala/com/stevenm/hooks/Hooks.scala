package com.stevenm.hooks

import java.nio.file.{Files, Paths}

import com.stevenm.state.TestState
import cucumber.api.scala.ScalaDsl
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser._

import scala.util.Properties

class Hooks extends ScalaDsl {

  private[this] lazy val screenshotDir = Files.createDirectories(Paths.get(Properties.propOrElse("screenshot.dir", "screenshots"))).toFile.getAbsolutePath

  After(Int.MaxValue) {
    scenario => {
      if (scenario.isFailed) {
        implicit val webDriver: WebDriver = TestState.webDriver

        setCaptureDir(screenshotDir)
        captureTo(s"${scenario.getName}.png")
      }
    }
  }

  scala.sys.addShutdownHook {
    TestState.webDriver.close()
    TestState.webDriver.quit()
  }
}
