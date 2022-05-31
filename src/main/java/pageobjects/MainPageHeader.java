package pageobjects;

import enums.MenuItems;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageHeader extends AbstractPage{
    WebDriver driver;

    public MainPageHeader(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // this initializes @FindBy elements
    }

    @FindBy(css = ".header-container ")
    private WebElement header;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    @FindBy(css = ".search__btn")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@class = 'menu-vertical__item group ']/descendant::a[text()='Одяг']/parent::li")
    private WebElement catalogOpenButton;

    @FindBy(xpath = "//div[@class = 'catalog-menu__section']/a[text()='Чоловікам']")
    private WebElement manCatalogButton;

    public WebElement getHeaderMenuItem(String item){
        try {
            return driver.findElement(By.xpath(String.format("//span[.='%s']/ancestor::div[@class='header-menu_item']", item)));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format("There is no menu item with name '%s'", item));
        }
    }


    public WebElement getCatalogMenuItem(String item){
        try {
            return driver.findElement(By.xpath(String.format("//div[@class = 'catalog-menu__section']/a[text()='%s']", item)));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format("There is no menu item with name '%s'", item));
        }
    }

    public void clickHeaderMenuItem(String item){
        getHeaderMenuItem(item).click();
    }

    public void openCatalogClick(){
        catalogOpenButton.click();
    }

    public void openManCatalog(){
        manCatalogButton.click();
    }
}
