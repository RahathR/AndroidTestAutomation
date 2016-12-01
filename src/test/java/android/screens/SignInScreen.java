/**
 * 
 */
package android.screens;

import android.utilities.BaseActions;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * @author arafatmamun
 *
 */
public class SignInScreen extends BaseActions{

    @AndroidFindBy(id = "com.hcom.android:id/txt_sign_in_email_address")
    private static AndroidElement emailField;

    private static By passwordField = By.id("com.hcom.android:id/txt_sign_in_password");

    private static By signInButton = By.id("com.hcom.android:id/aut_sig_p_signin_btn_sign_in");

    @AndroidFindBy(id = "com.hcom.android:id/alertMessage")
    private static AndroidElement alertMessage;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private static List<AndroidElement> backButton;

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

    @Step
    public void tapOnBankButton(){
        tapOn(backButton.get(0));
    }
}
