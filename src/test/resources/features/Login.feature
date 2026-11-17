Feature: Application Login

  @smoke
  Scenario: Successful user login
    Given the user navigates to the login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should see the home page