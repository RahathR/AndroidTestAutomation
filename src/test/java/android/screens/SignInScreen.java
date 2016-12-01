/**
 * 
 */
package android.screens;

import android.utilities.BaseActions;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author arafatmamun
 *
 */
public class SignInScreen extends BaseActions{

    private static By emailField = By.id("com.hcom.android:id/txt_sign_in_email_address");
    private static By passwordField = By.id("com.hcom.android:id/txt_sign_in_password");
    private static By signInButton = By.id("com.hcom.android:id/aut_sig_p_signin_btn_sign_in");
    private static By alertMessage = By.id("com.hcom.android:id/alertMessage");

    @Step
    public void enterEmailAddress(String emailAddress){
        setValue(emailField, emailAddress);
    }

    @Step
    public void enterPassword(String password){
        setValue(passwordField, password);
    }

    @Step
    public void tapOnSignInButton(){
        tapOn(signInButton);
    }

    @Step
    public void verifyInvalidSignInMessage(){
        verifyText(getValueFromElementByText(alertMessage),
                "Sorry, we can’t verify your sign-in details. Please check that your email address and password are correct.");
    }
}
