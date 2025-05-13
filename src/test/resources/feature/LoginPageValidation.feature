@LoginPageValidation
Feature: Login Page Validation

  Scenario: Login Positive
    Given as an Admin I validate username,password and login button is visible
    When I enter a valid username and valid password
    And I enter login button
    Then Student Information System should be visible

  Scenario: Login Negative 1
    Given as an Admin I validate username,password and login button is visible
    When I enter a valid username and wrong password
    And I enter login button
    Then Student Information System should not be visible

  Scenario: Login Negative 2
    Given as an Admin I validate username,password and login button is visible
    When I enter a wrong username and valid password
    And I enter login button
    Then Student Information System should not be visible

  Scenario: Login Negative 3
    Given as an Admin I validate username,password and login button is visible
    When I enter a wrong username and wrong password
    And I enter login button
    Then Student Information System should not be visible
