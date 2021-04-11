package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/Features/SportPage.feature" ,
        glue = {"stepDefinitions"},
        plugin = {"pretty" , "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json" ,
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//                "timeline:test-output-thread/"
                }

)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
