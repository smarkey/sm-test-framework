package com.stevenm.steps

import com.stevenm.pages._
import com.stevenm.utils.SeleniumCucumberTest

import scala.util.Properties
import org.scalatest.time._

class SearchSteps extends SeleniumCucumberTest {

  implicit val host: String = Properties.propOrElse("env.url", "https://www.just-eat.co.uk")

  Given("""^I want food in "(.+)"$""") { (postcode: String) =>
    val page = new SearchPage()
    go to page
    eventually (timeout(Span(10, Seconds)), interval(Span(500, Milliseconds))) {
      pageTitle should be("Order takeaway online from 20,000+ food delivery restaurants | Just Eat")
    }

    page.postcode.value = postcode
  }

  When("""^I search for restaurants$""") { () =>
    submit()
  }

  Then("""^I should see some restaurants in "(.+)"$""") { (postcode: String) =>
    val page = new SearchResultsPage()
    eventually (timeout(Span(10, Seconds)), interval(Span(500, Milliseconds))) {
      page.heading.text should include(postcode)
    }
  }

  When("""^I browse for "(.+)" restaurants$"""){ (cuisine: String) =>
    val page = new SearchPage()
    val el = cuisine match {
      case "Italian" => page.italian.underlying
    }
    el.click()
  }

  Then("""^I should see some chinese restaurants in "([^"]*)"$"""){ (cuisine: String) =>
    val page = new SearchResultsPage()
    eventually (timeout(Span(10, Seconds)), interval(Span(500, Milliseconds))) {
      page.heading.text should include(cuisine)
    }
  }

  When("""^I filter on "(.+)"$"""){ (cuisine: String) =>
    val page = new SearchResultsPage()
    val el = cuisine match {
      case "African" => page.african.underlying
    }
    el.click()
  }

  Then("""^I should see (\d+) result$"""){ (numberOfResults: Int) =>
    eventually (timeout(Span(10, Seconds)), interval(Span(500, Milliseconds))) {
      new SearchResultsPage().results.length should be(numberOfResults)
    }
  }

  Then("""^the top result is "([^"]*)"$"""){ (restaurantName: String) =>
    val page = new SearchResultsPage()
    eventually (timeout(Span(10, Seconds)), interval(Span(500, Milliseconds))) {
      page.results.next.text should include(restaurantName)
    }
  }
}
