@SignIn @Regression
Feature: Sign In Screen

	@invalidSignIn
	Scenario: Login as Invalid Hotels User
		Given I am on Home screen of Hotels
	    And I tap on Sign in button from the menu
	    And I enter Email as 'testusername@gmail.com' on the sign in screen
	    And I enter Password as 'Test89!!Pass' on the sign in screen
	    When I tap on Sign In button on the sign in screen
	    Then I am presented with an popup message