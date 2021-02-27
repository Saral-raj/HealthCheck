package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;
    public BaseTest(){
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("/Users/sarakarthik/IdeaProjects/Courier-HealthChecks/src/" +
                    "test/java/appConfig/Config.properties");
            prop.load(fis);
        }
        catch (IOException e){
            e.getMessage();
        }
    }


    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/sarakarthik/Downloads/Jars And Drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.chrome.driver", "/Users/sarakarthik/Downloads/Jars And Drivers/chromedriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(BaseUtilities.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(BaseUtilities.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
