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
public class HomeScreen extends BaseActions{

    private static By alertOkButton = By.id("com.hcom.android:id/btnPositive");
    private static By menuIcone = By.className("android.widget.ImageButton");
    private static By menuSignInButton = By.id("com.hcom.android:id/drawer_header_sign_in");

    @Step
    public void acceptNotificationAlert(){
        tapOn(alertOkButton);
    }

    @Step
    public void tapOnHomePageSignInButton(){
        tapOnMenuIcon();
        tapOn(menuSignInButton);
    }

    @Step
    public void tapOnMenuIcon(){
        tapOn(menuIcone);
    }
}
