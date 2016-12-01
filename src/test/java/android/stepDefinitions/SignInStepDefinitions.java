/**
 * 
 */
package android.stepDefinitions;

import android.screens.HomeScreen;
import android.screens.SignInScreen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author arafatmamun
 *
 */
public class SignInStepDefinitions{
	
	HomeScreen homeScreen;
	SignInScreen signInScreen;
	
	public SignInStepDefinitions(HomeScreen homeScreen, SignInScreen signInScreen){
		this.homeScreen = homeScreen;
		this.signInScreen = signInScreen;
	}
	
	@Given("^I am on Home screen of Hotels$")
	public void onHomeScreen(){
		homeScreen.acceptNotificationAlert();
	}

	@Given("^I tap on Sign in button from the menu")
	public void tapOnSignInButtonFromMenu(){
		homeScreen.tapOnSignInButtonFromMenu();
	}

	@Given("^I enter (Email|Password) as '([a-zA-Z0-9!@#$%^&*.()\\[\\]\"]+)' on the sign in screen$")
	public void enterUserNameAndPassword(String inputType, String value){
		if(inputType.equals("Email")){
			signInScreen.enterEmailAddress(value);
		} else{
			signInScreen.enterPassword(value);
		}
	}

	@When("^I tap on Sign In button on the sign in screen$")
	public void tapOnSignInScreenSignInButton(){
		signInScreen.tapOnSignInButton();
	}

	@Then("^I am presented with an popup message$")
	public void verifyInvalidSignInMessage(){
		signInScreen.verifyInvalidSignInMessage();
	}
}
