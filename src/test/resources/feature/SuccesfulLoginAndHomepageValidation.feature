@SuccessfulLoginAndHomepageValidation
Feature: SuccesfulLoginAndHomepageValidation

  @P
  Scenario: SuccesfulLoginAndHomepageValidation Positive
    When I enter a valid username and valid password
    And I enter login button
    Then I validate MainPage subtab is visible
    And I validate Announcements section is visible
    And I Validate that the logo is visible
    And I validate that the URL includes the MainPage.aspx extension

  @N1
  Scenario: SuccesfulLoginAndHomepageValidation Negative1
    When I enter a valid username and wrong password
    And I enter login button
    Then I validate MainPage subtab is NOT visible
    And I validate Announcements section is NOT visible
    And I Validate that the logo is NOT visible
    And I validate that the URL does not include the MainPage.aspx extension

  @N2
  Scenario: SuccesfulLoginAndHomepageValidation Negative2
    When I enter a wrong username and valid password
    And I enter login button
    Then I validate MainPage subtab is NOT visible
    And I validate Announcements section is NOT visible
    And I Validate that the logo is NOT visible
    And I validate that the URL does not include the MainPage.aspx extension

  @N3
  Scenario: SuccesfulLoginAndHomepageValidation Negative3
    When I enter a wrong username and wrong password
    And I enter login button
    Then I validate MainPage subtab is NOT visible
    And I validate Announcements section is NOT visible
    And I Validate that the logo is NOT visible
    And I validate that the URL does not include the MainPage.aspx extension
