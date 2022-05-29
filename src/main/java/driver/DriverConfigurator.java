package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Supplier;

public class DriverConfigurator {
    protected WebDriver webDriver;
    protected static final long DEFAULT_TIMEOUT_TO_WAIT = 40;

    public WebDriver setupDriver(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return (WebDriverWait) new WebDriverWait(webDriver, DEFAULT_TIMEOUT_TO_WAIT)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT_TO_WAIT))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

}
