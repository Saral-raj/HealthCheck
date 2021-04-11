package stepDefinitions;
import domainPages.HomePage;
import domainPages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.BaseTest;
import utilities.BaseUtilities;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class HomePageSteps extends BaseTest {
    HomePage homePage = new HomePage();

    @And("I Should validate Homepage title")
    public void iShouldValidateHomepageTitle() {
        homePage.validateMainMenu();
    }

    @And("I click on NEWS from menu")
    public void iClickOnNEWSFromMenu() {
        homePage.clickOnNews();
    }


    @When("I click on Sport from menu")
    public void iClickOnSportFromMenu() {
        homePage.clickOnSport();
    }

    @Then("I Should redirected to NEWS page")
    public void iShouldRedirectedToNEWSPage() {
        homePage.assertURL();

    }

    @Then("I click on loginORregister")
    public void iClickOnLoginORregister() throws IOException {
        homePage.clickOnLogin();
    }

    @Then("I Should see TopMenu labels")
    public void iShouldSeeTopMenuLabels() {
        homePage.verifyTopmenu();
    }

    @When("I click on POLITICS from menu")
    public void iClickOnPOLITICSFromMenu() {

        homePage.clickOnPolitics();
    }

    @And("I provide {string} in search box")
    public void iProvideInSearchBox(String keyWord) {

        homePage.inputSearchWord(keyWord);
    }

    @Then("I get the total results and assert the pagination")
    public void iGetTheTotalResultsAndAssertThePagination() {
        homePage.verifyresultswithpagination();
    }

    @And("I assert search filters")
    public void iAssertSearchFilters() {
        homePage.assertSearchFilters();
    }

    @And("I assert Author filters and assert the pagination")
    public void iAssertAuthorFiltersAndAssertThePagination() {
        homePage.assertAuthorResultswithpagination();
    }

    @Then("I click on Facebook Icon and verify FBpage")
    public void iClickOnFacebookIconAndVerifyFBpage() {
        homePage.clickOnFBAndVerifyFBPage();
    }

    @And("I click on Twitter Icon and verify twitter page")
    public void iClickOnTwitterIconAndVerifyTwitterPage() {
        homePage.clickOnFTwitterAndVerifyPage();
    }

    @Then("I verify clearfix list")
    public void iVerifyClearfixList() {
        BaseUtilities.verifyArticleCount("//ul[@class='verticals clearfix']","li","6");
    }

    @And("I verify TopMainmenu list")
    public void iVerifyTopMainmenuList() {
        BaseUtilities.verifyArticleCount("//ul[@class='nav-bar clearfix']","li","40");
    }

}
