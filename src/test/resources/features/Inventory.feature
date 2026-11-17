
Feature: Inventory management

  Background:
    Given the user navigates to the login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should see the home page

  @inventory @regression
  Scenario: Verify inventory list size
    Given user is on the inventory page
    When user retrieves the inventory list
    Then the inventory list should contain 6 items

  @inventory @sorting
  Scenario: Sort inventory by price in descending order
    Given user is on the inventory page
    When user sorts inventory by price from high to low
    Then inventory items should be displayed in descending price order
