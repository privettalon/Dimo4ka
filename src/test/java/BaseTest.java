import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://kasta.ua/uk/");
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
