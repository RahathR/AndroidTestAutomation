/**
 * 
 */
package android.utilities;

import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;


/**
 * @author arafatmamun
 *
 */
public abstract class BaseActions extends AndroidDriverFactory{

    /**
     * Find Element using BY
     * @param element
     * @return
     */
    public AndroidElement findElement(By element) {
        int attempts = 5;
        while (attempts > 0) {
            try {
                return (AndroidElement) getAndroidDriver().findElement(element);

            } catch (NoSuchElementException e) {
                if (attempts == 1) {
                    takeScreenShot();
                        Assert.fail("Unable to locate the Element using: " + element.toString());
                        throw new NoSuchElementException("Unable to locate the Element using: " + element.toString());
                }
            }
            attempts--;
            thinkTime(1000);
        }
        return null;
    }

    /**
     * Tap on Element
     * @param elementToTap
     */
    protected void tapOn(By elementToTap) {
        int attempts = 1;
        while (attempts > 0) {
            try {
                    findElement(elementToTap).tap(1,1);
                    break;
            } catch (NoSuchElementException exception) {
                if (attempts == 1) {
                    takeScreenShot();
                }
            }
            attempts--;
            thinkTime(100);
        }
    }

    /**
     * Set value on input field
     * @param androidElement
     * @param valueToSet
     */
    protected void setValue(By androidElement, String valueToSet){
        int attempts = 5;
        while (attempts > 0) {
            try {
                findElement(androidElement).sendKeys(valueToSet);
                break;
            } catch (NoSuchElementException e) {
                if (attempts == 1) {
                    takeScreenShot();
                }
            }
            attempts--;
            thinkTime(100);
        }
    }

    /**
     * Get value from an element by text
     * @param androidElement
     * @return
     */
    protected String getValueFromElementByText(By androidElement) {
        int attempts = 2;
        while (attempts > 0) {
            try {
                return findElement(androidElement).getText();
            } catch (NoSuchElementException e) {
                if (attempts == 1) {
                    takeScreenShot();
                    Assert.fail("Unable to locate the Element using: " + androidElement.toString());
                    throw new NoSuchElementException("Unable to locate the Element using: " + androidElement.toString());
                }
            }
            attempts--;
            thinkTime(100);
        }
        return "";
    }

    /**
     * Assert to verify text
     * @param actualText
     * @param expectedText
     */
    protected void verifyText(String actualText, String expectedText){
        try {
            Assert.assertEquals(actualText, expectedText);
        } catch (AssertionError assertionError) {
            takeScreenShot();
            assertionError.printStackTrace();
            throw assertionError;
        }
    }

    /**
     * Implement Sleep
     * @param enterTime
     */
    public static void thinkTime(int enterTime) {
        try {
            Thread.sleep(enterTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Take Screenshot if error happens
     */
    private static void takeScreenShot() {
        final byte[] screenshot = ((TakesScreenshot) getAndroidDriver())
                .getScreenshotAs(OutputType.BYTES);
        attachScreenshot(screenshot);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private static byte[] attachScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
