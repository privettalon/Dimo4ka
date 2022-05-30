import org.testng.annotations.Test;
import pageobjects.MainPage;

public class LoginTest extends BaseTest {

    @Test
    public void test1(){
        new MainPage(driver).openProfilePage();
    }
}
