Feature: different functionality
  @register
  Scenario: User should be able to register successfully
    Given User is on home page
    When User enters all the details
    Then User should be register successfully
  @email
  Scenario: Registered user should be able to send an email  with product
    Given User is already registered
    When User send an email to friend with product
    Then An email should be send to friend
  @email
  Scenario: Unregistered user should not be able to send an email with product
    Given User is on home page
    When User send an email to friend with product
    Then An email should not be send to friend
  @sortby
  Scenario: User should be able to sort price by High to Low
    Given User is on product page
    When User sort price by high to low
    Then All product should be sorted by price displaying high to low
  @purchase
  Scenario: Registered user should be able to purchase a product
    Given User is already logged in
    When User purchase a product
    Then Order successful message should be displayed
  @purchase
  Scenario: User should not be able to proceed without agreeing terms and condition
    Given User has added a  product  in shopping cart
    When User try to purchase a product without agreeing terms and condtion
    Then User should not be able to proceed
  @homepage
  Scenario: Verify add to cart button is present for all products on home page
    Given User is on home page
    When User scroll to view products on homepage
    Then Add to cart button should be present for all products
  @currency
  Scenario: Verify jewelry price displayed in dollar
    Given User is on jewelry page
    When User select currency as dollar
    Then Price should be displayed in dollar currency
  @currency
  Scenario: Verify jewelry price displayed in euro
    Given User is on jewelry page
    When User select currency as euro
    Then Price should be displayed in euro currency
