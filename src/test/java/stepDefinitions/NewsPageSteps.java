package stepDefinitions;
import domainPages.NewsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import utilities.BaseTest;
import utilities.BaseUtilities;

import java.io.IOException;

public class NewsPageSteps extends BaseTest{
    NewsPage newsPage = new NewsPage();

//    @Then("I Should verify NEWS Icon")
//    public void iShouldVerifyNEWSIcon() throws IOException {
//        newsPage.validateNewsIcon();
//    }
    @Then("I Should verify Ad blocks")
    public void iShouldVerifyAdBlocks() {
        newsPage.verifyAdBlocks();
    }
    @Then("I Should assert Photo&Video block")
    public void iShouldAssertPhotoVideoBlock() {
        newsPage.verifyPhotoVideoblock();
        newsPage.verifyPhotoVideoblockNumber("//*[@id=\"content\"]/section[6]/div/div[2]/div/div/div","article","30");
    }

    @Then("I Should assert Papertray block")
    public void iShouldAssertPapertrayBlock() {
        newsPage.verifyPaperTrayblock();
        BaseUtilities.verifyArticleCount("//*[@id='content']/section[7]/div/div[2]","article","25");
    }

    @Then("I Should verify Submenu list")
    public void iShouldVerifySubmenuList() {
        newsPage.verifyNewsSubmenu();
        BaseUtilities.verifyArticleCount("//*[@id=\"menu-item-316957\"]/ul","li","8");

    }

    @Then("I Should verify {string} Navigation")
    public void iShouldVerifySubMenuNavigation(String subMenu) throws IOException{
        newsPage.verifyNewsSubmenuNavigation(subMenu);

    }

    @Then("I Should verify PostBlock list")
    public void iShouldVerifyPostBlockList()  {
        newsPage.verifyPostBlock();
        BaseUtilities.verifyArticleCount("//*[@id=\"content\"]/section[4]/div/div[2]/div[1]/div", "article", "12");

    }

    @Then("I Should assert timeline block")
    public void iShouldAssertTimelineBlock() {
        newsPage.verifyTimelineBlock();
        BaseUtilities.verifyArticleCount("//*[@id='content']/section[4]/div/div[2]/div[2]/div/div[2]/div/ul","li","4");

    }

    @Then("I minimize the page and take pic of first half")
    public void iMinimizeThePageAndTakePicOfFirstHalf()  throws IOException {
        BaseUtilities.waitForPageToLoad();
        BaseUtilities.minimisePage();
        BaseUtilities.takeScreenshotAtEndOfTest();

    }

    @Then("I scroll down the page and take pic of second half")
    public void iScrollDownThePageAndTakePicOfSecondHalf() throws IOException{
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, 1200)");
        BaseUtilities.takeScreenshotAtEndOfTest();
    }


}

