package domainPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseTest;
import utilities.BaseUtilities;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseTest {
    // Page Factory
    @FindBy(id = "menu-item-316957")
    WebElement menuNews;
    @FindBy(id = "menu-item-1041701")
    WebElement menuPolitics;
    @FindBy(id = "menu-item-317019")
    WebElement menuSport;
    @FindBy(id = "menu-item-1015476")
    WebElement urlLogin;
    @FindBy(linkText = "Jobs")
    WebElement lblJobs;
    @FindBy(linkText = "Shop")
    WebElement lblShop;
    @FindBy(linkText = "Family Announcements")
    WebElement lblFamily;
    @FindBy(linkText = "Public Notices")
    WebElement lblPublic;
    @FindBy(linkText = "Photos")
    WebElement lblPhotos;
    @FindBy(linkText = "Courier Travel")
    WebElement lblTravel;
    @FindBy(xpath = "//*[@id=\"search-form__input--header\"]")
    WebElement fldSearch;
    @FindBy(xpath = "//*[@id=\"header-search-form\"]/button")
    WebElement btnSearch;
    @FindBy(xpath = "//a[@href='https://www.facebook.com/thecourieruk']")
    WebElement linkFB;
    @FindBy(xpath = "/html/body/header/div/div/div[1]/div/ul/li[2]/a")
    WebElement linkTwitter;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateMainMenu() {
        return menuNews.isDisplayed();
    }

    public void clickOnNews() {
        menuNews.click();
    }

    public void clickOnPolitics() {

        menuPolitics.click();
    }

    public void clickOnSport() {
        menuSport.click();
    }

    public void assertURL() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.thecourier.co.uk/category/news/");
    }

    public void clickOnLogin() {
        BaseUtilities.waitForPageToLoad();
        urlLogin.click();
    }

    public void clickOnFBAndVerifyFBPage() {
        BaseUtilities.waitForPageToLoad();
        linkFB.click();
        BaseUtilities.waitForPageToLoad();
            List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
            //switch to new tab
            driver.switchTo().window(browserTabs.get(1));
            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, "https://www.facebook.com/thecourieruk");
            driver.close();
            driver.switchTo().window(browserTabs.get(0));
        }
    public void clickOnFTwitterAndVerifyPage() {
        linkTwitter.click();
        BaseUtilities.waitForPageToLoad();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(browserTabs.get(1));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://twitter.com/thecourieruk");
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

        public void verifyTopmenu () {
            Assert.assertEquals(true, lblJobs.isDisplayed());
            Assert.assertEquals(true, lblShop.isDisplayed());
            Assert.assertEquals(true, lblFamily.isDisplayed());
            Assert.assertEquals(true, lblPublic.isDisplayed());
            Assert.assertEquals(true, lblPhotos.isDisplayed());
            Assert.assertEquals(true, lblTravel.isDisplayed());
        }
        public void inputSearchWord (String keyWord){
            BaseUtilities.waitForPageToLoad();
            fldSearch.sendKeys(keyWord);
            btnSearch.click();
        }
//    public static getTotalResult() {
//        BaseUtilities.waitForPageToLoad();
//        String number = driver.findElement(By.xpath("//h1[@class='results__title title--border']")).getText();
//        String splits[] = number.split(" ",3);
//        System.out.println(splits[0]);
//        int fnumber = Integer.parseInt(splits[0]);
//       Integer expectedPagination = (fnumber%25);
//        System.out.println(expectedPagination);
//
//    }
        public void verifyresultswithpagination () {
            BaseUtilities.waitForPageToLoad();
            String number = driver.findElement(By.xpath("//h1[@class='results__title title--border']")).getText();
            String splits[] = number.split(" ", 3);
            int fnumber = Integer.parseInt(splits[0]);
            System.out.println(fnumber);
            Integer expectedPagination = (fnumber % 25);
            System.out.println(expectedPagination);
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0, 3000)");
            WebElement btnLastPage = driver.findElement(By.xpath("//a[@class='page-numbers'][last()]"));
            btnLastPage.click();
            WebElement articleLocation = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[2]"));
            List<WebElement> articleList = articleLocation.findElements(By.tagName("article"));
            int articleCount = articleList.size();
            if (expectedPagination != 0) {
                Assert.assertEquals(Integer.parseInt(String.valueOf(expectedPagination)), articleCount);
            } else {
                Assert.assertEquals(25, articleCount);
                System.out.println("hisara");
            }
        }
        public void assertSearchFilters () {
            String pageSource = driver.getPageSource();
            boolean authorFilter = pageSource.contains("Author");
            boolean dateFilter = pageSource.contains("Post Date");
            boolean categoryFilter = pageSource.contains("Category");

        }
        public void assertAuthorResultswithpagination () {
            BaseUtilities.waitForPageToLoad();
            String paFilter = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/div[2]/div[1]/ul/li[1]/a/span[2]")).getText();
            String splits[] = paFilter.split(" ");
            int fnumber = Integer.parseInt(splits[0]);
            System.out.println(fnumber);
//        Integer expectedPagination = paFilter % 25;
//        System.out.println(expectedPagination);
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("window.scrollTo(0, 3000)");
//        WebElement btnLastPage = driver.findElement(By.xpath("//a[@class='page-numbers'][last()]"));
//        btnLastPage.click();
//        WebElement articleLocation = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[2]"));
//        List<WebElement> articleList = articleLocation.findElements(By.tagName("article"));
//        int articleCount = articleList.size();
//        if (expectedPagination!=0){
//            Assert.assertEquals(Integer.parseInt(String.valueOf(expectedPagination)), articleCount);
//        }
//        else {
//            Assert.assertEquals(25,articleCount);
//            System.out.println("hisara1");
//        }
        }

    }

