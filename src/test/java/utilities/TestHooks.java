package utilities;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class TestHooks extends ReportUtil{
    public static WebDriver driver;

    @After
    public void tearDown() {
        BaseTest.driver.quit();
        }

}
