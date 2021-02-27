package stepDefinitions;

import domainPages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseTest;

public class LoginPageSteps extends BaseTest{
    LoginPage loginPage = new LoginPage();

    @Given("I launch TheCourier Login CTA Url")
    public void iLaunchTheCourierLoginCTAUrl() {
        BaseTest.initialization();
    }
    @When("I accept the policy")
    public void iAcceptThePolicy() {
        loginPage.acceptPolicy();
    }

    @Then("I provide login details")
    public void iProvideLoginDetails() {
        loginPage.login(prop.getProperty("emailaddress"),prop.getProperty("password"));
    }




}
