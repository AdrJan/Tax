Feature: Automated tests for adding to cart.
  description: Checking if adding to cart works properly.

  Scenario: Customer is adding products to cart
    Given user wants following products
      | Faded Short Sleeve T-shirts | 16.51 |
      | Printed Dress               | 26.00 |
      | Blouse                      | 27.00 |
    And user is on Home Page
    When user clicks on "Women" category
    When user adding products
    Then cart shows total cost