package com.stevenm.pages

import com.stevenm.utils.PageObject
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser._

class CategoryPage(implicit webdriver: WebDriver, host: String) extends PageObject("/index.php?controller=my-account", "") {

  def productLink: Option[Element] = find(xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]"))

  def quickViewLink: Option[Element] = find(className("quick-view"))

  def quickViewOverlay: Option[Element] = find("product")

  def sizeSelect: Option[Element] = find("group_1")

  def submitButton: Option[Element] = find("Submit")

  def productAdditionConfirmation: Option[Element] = find(xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"))

  def continueShopping: Option[Element] = find(xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"))

  def proceedToCheckout: Option[Element] = find(xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"))
}
