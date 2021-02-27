package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"Pretty","html:target/cucumber"},
        features="src/main/resources/Features/HomePage.feature",
        glue = {"stepDefinitions"}
        )
public class  testRunner extends AbstractTestNGCucumberTests {
}
