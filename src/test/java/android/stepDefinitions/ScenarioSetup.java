/**
 * 
 */
package android.stepDefinitions;

import java.net.MalformedURLException;

import android.utilities.AndroidDriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author arafatmamun
 *
 */
public class ScenarioSetup extends AndroidDriverFactory{
	
	@Before
	public void startAndroidDriver() throws MalformedURLException{
		buildAndroidDriver();
	}
	
	@After
	public void stopAndroidDriver(){
		terminateAndroidDriver();
	}
}
