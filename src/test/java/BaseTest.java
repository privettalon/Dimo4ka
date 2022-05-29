import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
    ChromeDriver driver = new ChromeDriver();

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        driver.get("http://www.google.com");

    }

    @Test
    public void test1(){

    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
