package com.stevenm.pages
import com.stevenm.utils.PageObject
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser._

class HomePage(implicit webdriver: WebDriver, host: String) extends PageObject("/index.php", "My Store") {

  def login: Option[Element] = find(className("login"))

  def logout: Option[Element] = find(className("logout"))
}
