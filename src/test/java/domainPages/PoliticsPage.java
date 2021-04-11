package domainPages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseTest;
import utilities.BaseUtilities;

public class PoliticsPage  extends BaseTest {
    // Page Factory
    @FindBy(xpath = "//*[@id=\"content\"]/section[1]/div/div/h1")
    WebElement iconPolitics;
    @FindBy(xpath = "//*[@id=\"content\"]/section[2]/div/div/div[1]")
    WebElement blockPremiumGridMain;

    public PoliticsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyPoliticsIcon() {
        BaseUtilities.waitForPageToLoad();
        return iconPolitics.isDisplayed();
    }

    public void verifyMainBlockCount(String path, String tagName, String actual_count) {
        blockPremiumGridMain.isDisplayed();
        BaseUtilities.verifyArticleCount(path, tagName, actual_count);
    }

    public void verifyAsideBlockCount(String path, String tagName, String actual_count) {
        blockPremiumGridMain.isDisplayed();
        BaseUtilities.verifyArticleCount(path, tagName, actual_count);
    }



    public void verifyScottishPoliticsText() {
        String pageSource = driver.getPageSource();
        boolean result = pageSource.contains("More in Scottish politics");
        Assert.assertTrue(result);
    }
    public void verifyUKPoliticsText() {
        String pageSource = driver.getPageSource();
        boolean result = pageSource.contains("More in UK politics");
        Assert.assertTrue(result);
    }

    public void verifyScottishPoliticsTitle(String path,String tagName,String text) {
        BaseUtilities.verifyArticleTitle(path,tagName,text);
        }
    public void verifyAllPoliticsText() {
        String pageSource = driver.getPageSource();
        boolean result = pageSource.contains("All Politics Posts");

    }
    public void verifyPaperTrayPoliticsCount(String path, String tagName, String actual_count) {
        BaseUtilities.verifyArticleCount(path, tagName, actual_count);
    }
    public void verifyWPCPaperTrayPoliticsCount(String path, String tagName, String actual_count) {
        BaseUtilities.verifyArticleCount(path, tagName, actual_count);
    }
    }











