package pageobjects;

import driver.DriverConfigurator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Supplier;

public class AbstractPage {
    WebDriverWait webDriverWait;

    public AbstractPage() {
       // webDriverWait = new DriverConfigurator().getWebDriverWait();
    }

    public void waitUntil(Supplier<Boolean> condition) {
        webDriverWait.until(isTrue(condition));
    }

    public static ExpectedCondition<Boolean> isTrue(Supplier<Boolean> isTrue) {
        return driver -> isTrue.get();
    }
}
