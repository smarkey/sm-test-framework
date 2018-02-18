package com.stevenm.pages

import com.stevenm.utils.PageObject
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser._

class BasicPage(implicit webdriver: WebDriver, host: String) extends PageObject("/", "Google") {

  def searchButton: Option[Element] = find("btnK")
}
