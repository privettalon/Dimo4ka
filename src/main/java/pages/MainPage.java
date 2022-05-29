package pages;

import org.openqa.selenium.WebDriver;

public class MainPage {

    private MainPageHeader mainPageHeader;
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPageHeader getMainPageHeader() {
        return new MainPageHeader(driver);
    }


}
