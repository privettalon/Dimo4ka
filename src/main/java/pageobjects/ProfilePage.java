package pageobjects;

import driver.DriverConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;
import java.util.function.Supplier;

public class ProfilePage {
    private WebDriver driver;
    WebDriverWait webDriverWait = new DriverConfigurator().getWebDriverWait(driver);
    private WebElement popUp = driver.findElement(By.cssSelector(".popup--login"));

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProfilePageOpened(){
        return popUp.isDisplayed();
    }

    public ProfilePage waitUntilLoaded(){
        waitUntil(ExpectedConditions.visibilityOf(popUp));
        return this;
    }

    public void waitUntil(Function condition) {
        webDriverWait.until(condition);
    }
}
