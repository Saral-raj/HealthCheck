package domainPages;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseTest;
import utilities.BaseUtilities;

public class SportPage extends BaseTest {
    // Page Factory
    @FindBy(xpath = "//*[@id=\"content\"]/section[1]/div/div/h1")
    WebElement iconSport;
    @FindBy(id = "block_id_1")
    WebElement adBlock;
    @FindBy(xpath = "//div[@class='column column-tablet-sidebar sm-12 md-4 lg-4']")
    WebElement googleAdblock;
    @FindBy(id = "block_id_4")
    WebElement billboard;
    @FindBy(xpath = "//div[@class='sidebar-sticky hide-sm md-4 lg-4 -hide-print']")
    WebElement sideBarAdblock;

    public SportPage() {
        PageFactory.initElements(driver, this);
    }
    @Test
    public boolean verifySportIcon() {
        BaseUtilities.waitForPageToLoad();
        return iconSport.isDisplayed();
    }

    public void verifyAdBlocks() {
        adBlock.isDisplayed();
        JavascriptExecutor scrollEvent1 = ((JavascriptExecutor) driver);
        scrollEvent1.executeScript("window.scrollTo(0, 1200)");
        googleAdblock.isDisplayed();
        JavascriptExecutor scrollEvent2 = ((JavascriptExecutor) driver);
        scrollEvent2.executeScript("window.scrollTo(0, 2000)");
        billboard.isDisplayed();
        JavascriptExecutor scrollEvent3 = ((JavascriptExecutor) driver);
        scrollEvent3.executeScript("window.scrollTo(0, 3000)");
        sideBarAdblock.isDisplayed();
    }
}
