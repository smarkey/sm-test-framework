package com.stevenm.steps

import com.stevenm.pages._
import com.stevenm.utils.SeleniumCucumberTest
import org.scalatest.selenium.WebBrowser._

import scala.util.Properties

class BjssUiSteps extends SeleniumCucumberTest {

  implicit val host: String = Properties.propOrElse("env.url", "http://automationpractice.com")

  private[this] val username = "za2337474@mvrht.net"
  private[this] val password = "BJSSTest" //TODO: move this to an encrypted file using kdbx

  private[this] def loginPage = new LoginPage

  private[this] def homePage = new HomePage

  private[this] def categoryPage = new CategoryPage

  private[this] def myAccountPage = new MyAccountPage

  private[this] def orderPage = new OrderPage

  private[this] def orderHistoryPage = new OrderHistoryPage

  implicit val patience: PatienceConfig = PatienceConfig(timeout, interval)

  Given("""^the customer logs in$""") { () =>
    go to homePage
    homePage.login.head.underlying.click()
    eventually(pageTitle should be("Login - My Store"))

    loginPage.emailField.underlying.sendKeys(username)
    loginPage.passwordField.underlying.sendKeys(password)
    loginPage.loginButton.head.underlying.click()

    eventually(pageTitle should be("My account - My Store"))
  }

  When("""^the customer navigates to the '(.+)' page$""") { (page: String) =>
    page match {
      case "Order History And Details" =>
        myAccountPage.ordersLink.head.underlying.click()
        eventually(pageTitle should be("Order history - My Store"))
    }
  }

  When("""^the customer navigates to the '(.+)' category""") { (page: String) =>
    page match {
      case "T-shirts" =>
        hover(myAccountPage.tshirtsLink.head.underlying)
        eventually(myAccountPage.tshirtsLink.head.underlying.click())
        eventually(pageTitle should be("T-shirts - My Store"))
      case "Women > Blouses" =>
        hover(myAccountPage.womenLink.head.underlying)
        eventually(myAccountPage.womenBlousesLink.head.underlying.click())
        eventually(pageTitle should be("Blouses - My Store"))
    }
  }

  Then("""^the customer is on the '(.+)' page$""") { (pageName: String) =>
    pageName match {
      case "Quick View" => {
        webDriver.switchTo().frame(0)
        categoryPage.quickViewOverlay.head.isDisplayed
        webDriver.switchTo().parentFrame()
      }
    }
  }

  When("""^the customer changes the product size to '(.+)'$""") { (size: String) =>
    val sizeValue = size match {
      case "Small" => "S"
      case "Medium" => "M"
      case "Large" => "L"
    }

    webDriver.switchTo().frame(0)
    categoryPage.sizeSelect.head.underlying.sendKeys(sizeValue)
    webDriver.switchTo().parentFrame()
  }

  When("""^the customer adds the item to the cart$""") { () =>
    webDriver.switchTo().frame(0)
    categoryPage.submitButton.head.underlying.click()
    webDriver.switchTo().parentFrame()
  }

  Then("""^the customer receives confirmation that an item has been added to the cart$""") { () =>
    eventually(categoryPage.productAdditionConfirmation.head.underlying.getText should include("Product successfully added to your shopping cart"))
  }

  When("""^the customer chooses to '(.+)' after adding an item to the cart""") { (buttonText: String) =>
    def button = buttonText match {
      case "Continue shopping" => categoryPage.continueShopping
      case "Proceed to checkout" => categoryPage.proceedToCheckout
    }

    eventually(button.head.underlying.isDisplayed)
    eventually(button.head.underlying.click())
  }

  When("""^the customer quick views the first item$""") { () =>
    hover(categoryPage.productLink.head.underlying)
    categoryPage.quickViewLink.head.underlying.click()

    webDriver.switchTo().frame(0)
    eventually(categoryPage.quickViewOverlay.head.underlying.isDisplayed)
    webDriver.switchTo().parentFrame()
  }

  Then("""^the Summary displays the correct sizes, prices, number of items and total including shipping$""") { () =>
    orderPage.orderSummaryRows.size should be(2)
    orderPage.orderSummaryFirstRowSummary.head.underlying.getText should include("Size : M")
    orderPage.orderSummaryFirstRowPrice.head.underlying.getText should be("$16.51")
    orderPage.orderSummarySecondRowSummary.head.underlying.getText should include("Size : S")
    orderPage.orderSummarySecondRowPrice.head.underlying.getText should be("$27.00")
    orderPage.totalPrice.head.underlying.getText should be("$47.33")
  }

  Then("""^the customer proceeds to the '(.+)' step of checkout$""") { (checkoutStep: String) =>
    def button = checkoutStep match {
      case "Address" => orderPage.continueToCheckout
      case "Shipping" => orderPage.submitAddress
      case "Payment" => orderPage.submitCarrier
    }

    button.head.underlying.click()
  }

  Then("""^the customer agrees to the Terms of Service$""") { () =>
    orderPage.termsOfServiceCheckbox.select()
  }

  When("""^the customer chooses to '(.+)' for the order""") { (paymentType: String) =>
    def button = paymentType match {
      case "Pay by bank wire" => orderPage.payByBankWire
    }

    eventually(button.head.underlying.isDisplayed)
    button.head.underlying.click()
  }

  Then("""^the customer confirms the order$""") { () =>
    orderPage.confirmOrderButton.head.underlying.click()
  }

  Then("""^the order confirmation displays the correct amount$""") { () =>
    orderPage.orderConfirmationAmount.head.underlying.click()
  }

  Then("""^the customer logs out$""") { () =>
    homePage.logout.head.underlying.click()
    eventually(pageTitle should be("Login - My Store"))
  }

  When("""^the customer selects the latest order$""") { () =>
    orderHistoryPage.dateColumnHeader.head.underlying.click()
    orderHistoryPage.dateColumnHeader.head.underlying.click()

    orderHistoryPage.latestOrder.head.underlying.click()
    eventually(orderHistoryPage.orderDetails.head.underlying.isDisplayed)
  }

  When("""^the customer selects the '(.+)' item of the order$""") { (itemName: String) =>
    eventually(orderHistoryPage.orderItemSelect.head.underlying.sendKeys(itemName))
  }

  When("""^the customer adds the comment '(.+)'$""") { (commentText: String) =>
    orderHistoryPage.commentTextField.head.underlying.sendKeys(commentText)
    orderHistoryPage.commentSubmitButton.head.underlying.click()
    eventually(orderHistoryPage.commentAddedConfirmation.head.underlying.getText should include("Message successfully sent"))
  }

  Then("""^the comment text '(.+)' is displayed in the Messages section of the order$""") { (commentText: String) =>
    orderHistoryPage.messages.head.underlying.getText should include(commentText)
  }

  Then("""^the first order reference is '(.+)'$""") { (orderReference: String) =>
    logger.info("EXPECTING THIS TO FAIL - proves screenshot capture on failure")
    find(xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]")).head.underlying.getText should be(orderReference)
  }

}
