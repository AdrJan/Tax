Feature: Automated tests of products category bar
  Description: Checking if items in navigation bar are redirecting for correct categories.

  Scenario: Customer is iterating through products category menu items
    Given user is on Home Page
    When user clicks on "Women" category
    Then "Women" page is displayed
    When user clicks on "Dresses" category
    Then "Dresses" page is displayed
    When user clicks on "T-shirts" category
    Then "T-shirts" page is displayed
