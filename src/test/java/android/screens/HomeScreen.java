/**
 * 
 */
package android.screens;

import android.utilities.BaseActions;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author arafatmamun
 *
 */
public class HomeScreen extends BaseActions{

    private static By alertOkButton = By.id("com.hcom.android:id/btnPositive");

    private static By menuIcon = By.className("android.widget.ImageButton");

    @AndroidFindBy(id = "com.hcom.android:id/drawer_header_sign_in")
    private static AndroidElement menuSignInButton;

    private static By findToolBar = By.id("com.hcom.android:id/material_drawer_toolbar");

    @Step
    public void acceptNotificationAlert(){
        thinkTime(5000);
        tapOn(alertOkButton);
    }

    @Step
    public void tapOnSignInButtonFromMenu(){
        tapOnMenuIcon();
        tapOn(menuSignInButton);
    }

    @Step
    public void tapOnMenuIcon(){
        tapOn(menuIcon);
    }

    @Step
    public void verifyHomeScreen(){
        verifyTrue(isElementExists(findToolBar));
    }
}
