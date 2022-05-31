package pageobjects;

import enums.MenuItems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public class ProductPage extends AbstractPage{
    private WebDriver driver;
    private MainPageHeader mainPageHeader;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // this initializes @FindBy elements
    }

    @FindBy(xpath = "//*[@id=\"13659011:582\"]/div/div/form/div[2]/div[1]/div/div/button")
    private WebElement addToCart;

    @FindBy(xpath = "//li[@class = 'menu-vertical__item group ']/descendant::a[text()='Одяг']/parent::li")
    private WebElement catalogOpenButton;


    //для кожної сторінки інший локатор треба вставити
    public ProductPage waitUntilLoaded(){
        waitUntil(ExpectedConditions.visibilityOf(addToCart));
        return this;
    }

    //то теж треба на кожній сторінці юзати, або придумати як то винести в AbstractPage
    public void waitUntil(Function condition) {
        getWebDriverWait(driver).until(condition);
    }

    public CartPage openCartPage(){
        addToCart.click();
        mainPageHeader.clickHeaderMenuItem(MenuItems.CART.getName());
        return new CartPage(driver).waitUntilLoaded();
    }


}

