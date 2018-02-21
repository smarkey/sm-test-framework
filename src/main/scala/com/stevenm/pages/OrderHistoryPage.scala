package com.stevenm.pages

import com.stevenm.utils.PageObject
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser._

class OrderHistoryPage(implicit webdriver: WebDriver, host: String) extends PageObject("/index.php?controller=order-history", "Order History - My Store") {

  def dateColumnHeader: Option[Element] = find(xpath("//*[@id=\"order-list\"]/thead/tr/th[2]"))

  def latestOrder: Option[Element] = find(xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a"))

  def orderDetails: Option[Element] = find("block-order-detail")

  def orderItemSelect: Option[Element] = find("id_product")

  def commentSubmitButton: Option[Element] = find(xpath("//*[@id=\"sendOrderMessage\"]/div/button/span"))

  def commentTextField: Option[Element] = find("msgText")

  def messages: Option[Element] = find(xpath("//*[@id=\"block-order-detail\"]/div[5]/table/tbody/tr/td[2]"))

  def commentAddedConfirmation: Option[Element] = find(className("alert-success"))
}
