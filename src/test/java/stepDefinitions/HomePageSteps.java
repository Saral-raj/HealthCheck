package stepDefinitions;
import domainPages.HomePage;
import domainPages.LoginPage;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Priority;
import org.junit.Assert;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.BaseTest;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class HomePageSteps extends BaseTest {
    HomePage homePage = new HomePage();

    @And("I Should validate Homepage title")
    public void iShouldValidateHomepageTitle() {
        homePage.validateMainMenu();
    }

}
