/**
 * 
 */
package android.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author arafatmamun
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@Regression"},
		features = {"src/test/resources/features"},
		glue ="android/stepDefinitions"
		)

public class TestRunner {

}
