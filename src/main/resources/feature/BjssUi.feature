@ui
Feature:
  As a customer of automationpractice.com
  I want to add an item to my cart
  So that I can complete checkout the contents of my cart

  Background:
    Given the customer logs in

  @quick_view
  Scenario: A customer can 'Quick view' an item
    When the customer navigates to the 'T-shirts' category
    And the customer quick views the first item
    Then the customer is on the 'Quick View' page

  @happy_path @order_creation
  Scenario: A customer can place an order
    When the customer navigates to the 'T-shirts' category
    And the customer quick views the first item
    And the customer changes the product size to 'Medium'
    And the customer adds the item to the cart
    Then the customer receives confirmation that an item has been added to the cart
    When the customer chooses to 'Continue shopping' after adding an item to the cart
    And the customer navigates to the 'Women > Blouses' category
    And the customer quick views the first item
    And the customer adds the item to the cart
    And the customer chooses to 'Proceed to checkout' after adding an item to the cart
    Then the Summary displays the correct sizes, prices, number of items and total including shipping
    And the customer proceeds to the 'Address' step of checkout
    And the customer proceeds to the 'Shipping' step of checkout
    And the customer agrees to the Terms of Service
    And the customer proceeds to the 'Payment' step of checkout
    And the customer chooses to 'Pay by bank wire' for the order
    And the customer confirms the order
    Then the order confirmation displays the correct amount
    And the customer logs out

  @order_amendments
  Scenario: A customer can amend an order
    When the customer navigates to the 'Order History And Details' page
    And the customer selects the latest order
    And the customer selects the 'Blouse' item of the order
    And the customer adds the comment 'Is this blouse available in XXL?'
    Then the comment text 'Is this blouse available in XXL?' is displayed in the Messages section of the order

  @screenshot_failure
  Scenario: Screenshots are captured on scenario failure
    When the customer navigates to the 'Order History And Details' page
    Then the first order reference is 'NON-EXISTENT-REF'

