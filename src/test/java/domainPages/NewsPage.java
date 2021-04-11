package domainPages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseTest;
import utilities.BaseUtilities;

public class NewsPage extends BaseTest {

    // Page Factory
    @FindBy(xpath = "//*[@id=\"content\"]/section[1]/div/div/h1")
    WebElement iconNews;
    @FindBy(linkText = "CORONAVIRUS")
    WebElement txtCoronaVirus;
    @FindBy(linkText = "Dundee")
    WebElement txtDundee;
    @FindBy(linkText = "Angus & The Mearns")
    WebElement txtAngus;
    @FindBy(linkText = "Perth & Kinross")
    WebElement txtPerth;
    @FindBy(linkText = "Fife")
    WebElement txtFife;
    @FindBy(linkText = "Send us a story")
    WebElement txtStory;
    @FindBy(linkText = "Supplements")
    WebElement txtSupplements;
    @FindBy(linkText = "Home delivery")
    WebElement txtHomedelivery;
    @FindBy(id = "block_id_1")
    WebElement adblock;
    @FindBy(id = "block_id_4")
    WebElement billboard;
    @FindBy(xpath = "/html/body/iframe")
    WebElement googleAdblock;
    @FindBy(xpath = "//*[@id=\"google_ads_iframe_/4987/thecourier_4\"]")
    WebElement sideBarAdblock;
    @FindBy(xpath = "//*[@id=\"content\"]/section[4]/div/div[2]/div[2]/div/div[2]/div")
    WebElement blockTimeline;
    @FindBy(xpath = "//*[@id=\"content\"]/section[4]/div/div[2]/div[1]/div")
    WebElement blockPost;


    public NewsPage() {
        PageFactory.initElements(driver, this);
    }

    public void   validateNewsIcon() {
        BaseUtilities.waitForPageToLoad();
        Assert.assertTrue(iconNews.isDisplayed());
    }

    public void verifyAdBlocks() {
        adblock.isDisplayed();
        JavascriptExecutor scrollEvent1 = ((JavascriptExecutor) driver);
        scrollEvent1.executeScript("window.scrollTo(0, 1200)");
        googleAdblock.isDisplayed();
        JavascriptExecutor scrollEvent2 = ((JavascriptExecutor) driver);
        scrollEvent2.executeScript("window.scrollTo(0, 2000)");
        billboard.isDisplayed();
        JavascriptExecutor scrollEvent3 = ((JavascriptExecutor) driver);
        scrollEvent3.executeScript("window.scrollTo(0, 2500)");
        sideBarAdblock.isDisplayed();
    }

    public void verifyPhotoVideoblock() {
        String pageSource = driver.getPageSource();
        boolean result = pageSource.contains("News photos and video");

    }
    public void verifyPhotoVideoblockNumber(String path,String tagName,String actual_count) {
        BaseUtilities.verifyArticleCount(path,tagName,actual_count);
    }

    public void verifyPaperTrayblock() {
        String pageSource = driver.getPageSource();
        boolean result = pageSource.contains("All News Posts");

    }
    public void verifyTimelineBlock() {
        blockTimeline.isDisplayed();
    }
    public void verifyPostBlock() {
        blockPost.isDisplayed();
    }
    public void verifyNewsSubmenu() {
        Assert.assertEquals(true, txtCoronaVirus.isDisplayed());
        Assert.assertEquals(true, txtDundee.isDisplayed());
        Assert.assertEquals(true, txtAngus.isDisplayed());
        Assert.assertEquals(true, txtFife.isDisplayed());
        Assert.assertEquals(true, txtPerth.isDisplayed());
        Assert.assertEquals(true, txtStory.isDisplayed());
        Assert.assertEquals(true, txtSupplements.isDisplayed());
        Assert.assertEquals(true, txtHomedelivery.isDisplayed());
    }
    public void verifyNewsSubmenuCount(String path,String tagName,String actual_count) {
       BaseUtilities.verifyArticleCount(path,tagName,actual_count);
    }



    public void verifyNewsSubmenuNavigation(String subMenu) {
        switch (subMenu)
        {
            case "CORONAVIRUS":
                if
                (txtCoronaVirus.isDisplayed())
                {
                    txtCoronaVirus.click();
                    String URLC = driver.getCurrentUrl();
                    Assert.assertEquals(URLC, "https://www.thecourier.co.uk/tag/coronavirus/");
                }
                else {
                System.out.println("No Luck");
                }
                break;

                case "Dundee":
                    if (txtDundee.isDisplayed()) {
                        txtDundee.click();
                        String URLD = driver.getCurrentUrl();
                        Assert.assertEquals(URLD, "https://www.thecourier.co.uk/category/news/local/dundee/");
                    }
                    else{
                        System.out.println("No Luck");
                    }
                break;
            case "Angus & The Mearns":
                if
                (txtAngus.isDisplayed())
                {
                    txtAngus.click();
                    String URLA = driver.getCurrentUrl();
                    Assert.assertEquals(URLA, "https://www.thecourier.co.uk/category/news/local/angus-mearns/");
                }
                else {
                    System.out.println("No Luck");
                }
                break;
            case "Perth & Kinross":
                if
                (txtPerth.isDisplayed())
                {
                    txtPerth.click();
                    String URLP = driver.getCurrentUrl();
                    Assert.assertEquals(URLP, "https://www.thecourier.co.uk/category/news/local/perth-kinross/");
                }
                else {
                    System.out.println("No Luck");
                }
                break;
            case "Fife":
                if
                (txtFife.isDisplayed())
                {
                    txtFife.click();
                    String URLF = driver.getCurrentUrl();
                    Assert.assertEquals(URLF, "https://www.thecourier.co.uk/category/news/local/fife/");
                }
                else {
                    System.out.println("No Luck");
                }
                break;
            case "Send us a story":
                if
                (txtStory.isDisplayed())
                {
                    txtStory.click();
                    String URLS = driver.getCurrentUrl();
                    Assert.assertEquals(URLS, "https://www.thecourier.co.uk/send-us-a-story/");
                }
                else {
                    System.out.println("No Luck");
                }
                break;

            case "Supplements":
                if
                (txtSupplements.isDisplayed())
                {
                    txtSupplements.click();
                    String URLSS = driver.getCurrentUrl();
                    Assert.assertEquals(URLSS, "https://www.thecourier.co.uk/supplements/");
                }
                else {
                    System.out.println("No Luck");
                }
                break;

            case "Home delivery":
                if
                (txtHomedelivery.isDisplayed())
                {
                    txtHomedelivery.click();
                    String URLH = driver.getCurrentUrl();
                    Assert.assertEquals(URLH, "https://www.thecourier.co.uk/home-delivery/");
                }
                else {
                    System.out.println("No Luck");
                }
                break;


        }

    }
}



