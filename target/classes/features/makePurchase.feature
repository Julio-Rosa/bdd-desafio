@Test
Feature: Make purchase
  Scenario: make purchase
    Given That a user accesses the site "http://automationpractice.com/"
    And Search for product "Blouse"
    And Add the product "Blouse" to the cart
    And access the checkout
    And log in
    And Confirm the shipping address
    When Payment is confirmed
    Then The message should be displayed "Your order on My Store is complete."