package com.stevenm.pages

import com.stevenm.utils.PageObject
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser._

class SearchPage(implicit webdriver: WebDriver, host: String) extends PageObject("", "Order takeaway online from 20,000+ food delivery restaurants | Just Eat") {

  def postcode: TextField = textField("postcode")

  def italian = cssSelector("[cuisine='italian']").element
}
