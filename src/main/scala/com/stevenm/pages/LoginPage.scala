package com.stevenm.pages

import com.stevenm.utils.PageObject
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser._

class LoginPage(implicit webdriver: WebDriver, host: String) extends PageObject("/index.php?controller=authentication&back=my-account", "Login - My Store") {

  def emailField: TextField = textField("email")

  def passwordField: PasswordField = pwdField("passwd")

  def loginButton: Option[Element] = find("SubmitLogin")
}
