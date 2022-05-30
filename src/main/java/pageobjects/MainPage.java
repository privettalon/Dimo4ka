package pageobjects;

import enums.MenuItems;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private MainPageHeader mainPageHeader;
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.mainPageHeader = new MainPageHeader(driver);
    }

    public ProfilePage openProfilePage(){
        mainPageHeader.clickHeaderMenuItem(MenuItems.PROFILE.getName());
        return new ProfilePage(driver).waitUntilLoaded();
    }

    public CartPage openCartPage(){
        mainPageHeader.clickHeaderMenuItem(MenuItems.CART.getName());
        return new CartPage(driver);
    }
}
