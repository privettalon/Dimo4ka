package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverConfigurator {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected static final long DEFAULT_TIMEOUT_TO_WAIT = 40;

    public WebDriver setupDriver(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
//        webDriverWait = getWebDriverWait(webDriver);
        return webDriver;
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public WebDriverWait getWebDriverWait(WebDriver webDriver) {
        return (WebDriverWait) new WebDriverWait(webDriver, DEFAULT_TIMEOUT_TO_WAIT)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT_TO_WAIT))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

}
