package stepDefinitions;

import domainPages.SportPage;
import io.cucumber.java.en.Then;
import utilities.BaseTest;
import utilities.BaseUtilities;

public class SportPageSteps extends BaseTest {
    SportPage sportPage = new SportPage();
    @Then("I Should verify Sport Icon")
    public void iShouldVerifySportIcon()  {
        sportPage.verifySportIcon();
    }

    @Then("I Should verify Advertising blocks")
    public void iShouldVerifyAdvertisingBlocks() {
        sportPage.verifyAdBlocks();
    }

    @Then("I Should verify Sports Submenu list")
    public void iShouldVerifySportsSubmenuList() {
        BaseUtilities.verifyArticleCount("//*[@id=\"menu-item-317019\"]/ul","li", "9");
    }

}
