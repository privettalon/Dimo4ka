import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void test1(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Dimochka hihi");
    }
}
