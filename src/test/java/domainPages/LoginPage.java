package domainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import utilities.BaseTest;



public class LoginPage extends BaseTest {
    // Page Factory
    @FindBy(id="login_email")
    WebElement emailaddress;
    @FindBy(id="login_pass")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"form-login-register-wall\"]/form[2]/div[2]/button")
    WebElement btnLogin;
    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    WebElement btnAcceptPolicy;

    public LoginPage(){
        PageFactory.initElements(driver,this);
         }
        public String validateHomePageTitle() {
        return driver.getTitle();
        }
        public LoginPage login(String eadd, String pwd){
        emailaddress.clear();
        emailaddress.sendKeys(eadd);
        password.clear();
        password.sendKeys(pwd);
        return new LoginPage();
        }

        public void acceptPolicy() {
            WebElement acceptPolicy = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
            if (acceptPolicy.isDisplayed() && acceptPolicy.isEnabled()) {
                acceptPolicy.click();
            }

        }
        @AfterTest
        @AfterSuite
        @AfterMethod
        public void tearDown() {
        BaseTest.driver.quit();
    }
    }


