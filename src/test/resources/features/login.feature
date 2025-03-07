Feature: Login Functionality
  Background:
    Given I open the SauceDemo login page

  Scenario Outline: Valid login attempt
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see the products page

    Examples:
      | username       | password       |
      | standard_user | secret_sauce  |
      | invalid_user   | invalid_password  |
