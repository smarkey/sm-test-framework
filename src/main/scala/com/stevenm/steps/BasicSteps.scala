package com.stevenm.steps


import com.stevenm.pages.BasicPage
import com.stevenm.utils.SeleniumCucumberTest

import scala.util.Properties

class BasicSteps extends SeleniumCucumberTest {

  implicit val host: String = Properties.propOrElse("env.url", "http://www.google.com")

  When("""^I navigate to Google$""") { () =>
    val page = new BasicPage()
    go to page
    eventually {
      pageTitle should be("Google")
    }
  }

  Then("""^there is a '(.+)' button$""") { (buttonText: String) =>
    val page = new BasicPage()
    eventually {
      page.searchButton.map(_.underlying.getAttribute("value") should be(buttonText))
    }
  }
}
