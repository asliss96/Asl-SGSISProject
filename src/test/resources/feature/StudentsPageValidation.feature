@StudentsPageValidation
Feature: Students Page Validation

  Background: 
    Given as an Admin I validate username,password and login button is visible
    When I enter a valid username and valid password
    And I enter login button

  
  Scenario: Students Page Validation
    And I navigate to Students tab
    Then I validate these subtabs are visible
      | Personal             |
      | Parental             |
      | Academic             |
      | Override Final Grade |
      | Schedule             |
      | Discipline Stats     |
      | Personal 2           |
      | Enrollment           |
      | Notes                |
      | E-Portfolio          |
      | Program Enrollment   |
