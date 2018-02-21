package com.stevenm

import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.{WebDriver, WebElement}
import org.scalatest.concurrent.Eventually

package object steps extends Eventually {

  def hover(el: WebElement)(implicit webDriver: WebDriver): Boolean = {
    val actionBuilder: Actions = new Actions(webDriver)
    actionBuilder.moveToElement(el)
    actionBuilder.perform()
    eventually(el.isDisplayed)
  }
}
