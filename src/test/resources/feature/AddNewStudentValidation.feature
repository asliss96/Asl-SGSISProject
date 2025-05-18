@AddNewStudent
Feature: Add new student

  Background: 
    Given as an Admin I validate username,password and login button is visible
    And I enter a valid username and valid password
    And I enter login button
    And I navigate to Students tab

  @tag1
  Scenario: Adding new student
    When I enter the Add new button
    And I fill all textboxes except local id, username and grade section with the following data:
      | State Id | Last Name | First Name | SSN       | Email           | Password |
      |       66 | Ada     | Deniz      | 343234560 | deniz@gmail.com |    12345 |
    And I click submit changes
    Then I validate the student is saved succesfully
    And click Click to change to add photo
    Then I save username and password
