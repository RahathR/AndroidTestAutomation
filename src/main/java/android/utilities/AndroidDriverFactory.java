package android.utilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * 
 */

/**
 * @author arafatmamun
 *
 */
public class AndroidDriverFactory {
	
	private final static String platformVersion = "6.0";
	private final static String deviceName = "Android Emulator";
	
	private static AndroidDriver androidDriver;
	
	/**
	 * Build Android Driver to run test
	 * @throws MalformedURLException
	 * @author arafatmamun
	 */
	public static void buildAndroidDriver() throws MalformedURLException{

		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability("app", getAndroidApplication().getAbsolutePath());
        androidDriver = new AndroidDriver<>(new URL("http://0.0.0.0:9010/wd/hub"),
                capabilities);
	}

    /**
     * Method to get Android Driver
     * @return android driver instance
     * @author arafatmamun
     */
	public static AndroidDriver getAndroidDriver(){
        return androidDriver;
    }
	
	/**
	 * Get Android Application
	 * @return android application path
	 * @author arafatmamun
	 */
    private static File getAndroidApplication(){
        String currentDirectory = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");
        File appDir = new File(currentDirectory + fileSeparator + "androidApk");
        File app = new File(appDir, "hotels.com.apk");
        return app;
    }
    
    /**
     * Terminate Android
     * @author arafatmamun
     */
    public static void terminateAndroidDriver(){
    	androidDriver.quit();
    }
}
