package pages;

import driver.DriverConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Supplier;

public class ProfilePage {
    private WebDriver driver;
    WebDriverWait webDriverWait = new DriverConfigurator().getWebDriverWait();
    private WebElement popUp = driver.findElement(By.cssSelector(".popup--login"));

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProfilePageOpened(){
        return popUp.isDisplayed();
    }

    public ProfilePage waitUntilLoaded(){
        waitUntil(() -> isProfilePageOpened());
        return this;
    }

    public void waitUntil(Supplier<Boolean> condition) {
        webDriverWait.until(isTrue(condition));
    }

    public static ExpectedCondition<Boolean> isTrue(Supplier<Boolean> isTrue) {
        return driver -> isTrue.get();
    }


}
