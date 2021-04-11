package stepDefinitions;

import domainPages.LoginPage;
import domainPages.NewsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseTest;

public class LoginPageSteps extends BaseTest {
        LoginPage loginPage = new LoginPage();
        NewsPage newsPage =new NewsPage();

@Given("^I launch TheCourier Login CTA Url$")
public void i_launch_TheCourier_Login_CTA_Url() throws Throwable {
   BaseTest.initialization();

}
    @When("^I accept the policy$")
    public void i_accept_the_policy() throws Throwable{
        loginPage.acceptPolicy();
    }
    @Then("^I Should verify NEWS Icon$")
    public void i_Should_verify_NEWS_Icon(){
    newsPage.validateNewsIcon();

}

}

