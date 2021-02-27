package domainPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        emailaddress.sendKeys(eadd);
        password.sendKeys(pwd);
        return new LoginPage();
        }
        public void acceptPolicy() {
        try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
            btnAcceptPolicy.click();
            }

        }
    }


