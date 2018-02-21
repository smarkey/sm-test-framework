package com.stevenm.pages

import com.stevenm.utils.PageObject
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser._

class MyAccountPage(implicit webdriver: WebDriver, host: String) extends PageObject("/index.php?controller=my-account", "My Account - My Store") {

  def tshirtsLink: Option[Element] = find(xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a"))

  def womenLink: Option[Element] = find(xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"))

  def womenBlousesLink: Option[Element] = find(xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a"))

  def ordersLink: Option[Element] = find(xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a"))
}
