package com.stevenm.pages

import com.stevenm.utils.PageObject
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser._

class SearchResultsPage(implicit webdriver: WebDriver, host: String) extends PageObject("/area/bs34-bristol", "Restaurants and takeaways in Bristol, BS34 | Just Eat") {

  def heading = cssSelector("h1").element

  def african = cssSelector("""a[title*="African"]""").element

  def results = cssSelector(".c-restaurant").findAllElements
}
