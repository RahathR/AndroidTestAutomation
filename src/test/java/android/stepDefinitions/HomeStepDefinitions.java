package android.stepDefinitions;

import android.screens.HomeScreen;
import android.screens.SignInScreen;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by arafatmamun on 12/1/16.
 */
public class HomeStepDefinitions {

    HomeScreen homeScreen;
    SignInScreen signInScreen;

    public HomeStepDefinitions(HomeScreen homeScreen, SignInScreen signInScreen){
        this.homeScreen = homeScreen;
        this.signInScreen = signInScreen;
    }

    @When("^I tap on back button on the sign in screen$")
    public void tapOnBackButtonFromSignInScreen(){
        signInScreen.tapOnBankButton();
    }

    @Then("^I am back to home screen$")
    public void verifyHomeScreen(){
        homeScreen.verifyHomeScreen();
    }
}
