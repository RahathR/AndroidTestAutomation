@Home @Regression
Feature: Home Screen

  @returnToHome
  Scenario: User is ABle to return to home from sign in screen
    Given I am on Home screen of Hotels
    And I tap on Sign in button from the menu
    When I tap on back button on the sign in screen
    Then I am back to home screen