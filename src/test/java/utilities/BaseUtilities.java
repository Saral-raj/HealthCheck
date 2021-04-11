package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class BaseUtilities extends BaseTest {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 30;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        try {
            FileUtils.copyFile(scrFile, new File(currentDir + "/TestResults/"  + timeStamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
@BeforeTest
    public static void minimisePage(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.25'");
    }

    public static void verifyArticleCount(String path,String tagName,String  actualCount) {
        WebElement articleOnTray= driver.findElement(By.xpath(path));
        List<WebElement> articleCount = articleOnTray.findElements(By.tagName(tagName));
        System.out.println("ArticleCount is: " +articleCount.size());
        Assert.assertEquals(Integer.parseInt(actualCount), articleCount.size());
    }
    public static void verifyArticleTitle(String path,String tagName,String text) {
        WebElement title = driver.findElement(By.xpath(path));
        List<WebElement> TitleList = title.findElements(By.tagName(tagName));
        int Title = TitleList.size();
        System.out.println(Integer.parseInt(String.valueOf(Title)));
            for (int i = 1; i < Title; i++) {
                String myText = TitleList.get(0).getText();
                System.out.println(myText);
            for (String txtTitle : myText.split(" ")) {
                if (txtTitle.contains(text))
                {
//                    Assert.assertTrue(txtTitle.contains(text));
                    System.out.println("TitleList has contains" + text);
                }
                break;
                }
            }

        }

    public static void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}




