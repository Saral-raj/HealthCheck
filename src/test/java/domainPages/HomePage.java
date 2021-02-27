package domainPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseTest;

import java.util.concurrent.TimeUnit;

public class HomePage extends BaseTest
{
    // Page Factory
    @FindBy(id="menu-item-316957")
    WebElement menuNews;
    @FindBy(id="menu-item-1041701")
    WebElement menuPolitics;

    public HomePage(){
            PageFactory.initElements(driver,this);
    }
    public boolean validateMainMenu() {
    return menuNews.isDisplayed();

    }
}
