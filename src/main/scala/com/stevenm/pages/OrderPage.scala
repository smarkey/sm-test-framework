package com.stevenm.pages

import com.stevenm.utils.PageObject
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser._

class OrderPage(implicit webdriver: WebDriver, host: String) extends PageObject("/index.php?controller=order", "Order - My Store") {

  def orderSummaryRows: List[Element] = findAll(xpath("//table[@id=\"cart_summary\"]/tbody/tr")).toList

  def orderSummaryFirstRowSummary: Option[Element] = find(xpath("//table[@id=\"cart_summary\"]/tbody/tr[1]/td[2]"))

  def orderSummaryFirstRowPrice: Option[Element] = find(xpath("//table[@id=\"cart_summary\"]/tbody/tr[1]/td[6]"))

  def orderSummarySecondRowSummary: Option[Element] = find(xpath("//table[@id=\"cart_summary\"]/tbody/tr[2]/td[2]"))

  def orderSummarySecondRowPrice: Option[Element] = find(xpath("//table[@id=\"cart_summary\"]/tbody/tr[2]/td[6]"))

  def totalPrice: Option[Element] = find("total_price")

  def termsOfServiceCheckbox: Checkbox = checkbox("cgv")

  def payByBankWire: Option[Element] = find(className("bankwire"))

  def confirmOrderButton: Option[Element] = find(xpath("//*[@id=\"cart_navigation\"]/button/span"))

  def orderConfirmationAmount: Option[Element] = find(xpath("//*[@id=\"center_column\"]/div/span/strong"))

  def continueToCheckout = find(xpath("//*[@id=\"center_column\"]/p[2]/a[1]"))

  def submitAddress = find("processAddress")

  def submitCarrier = find("processCarrier")
}
