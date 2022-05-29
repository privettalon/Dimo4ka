import org.testng.annotations.Test;
import pages.MainPage;

public class LoginTest extends BaseTest {


    @Test
    public void test1(){

        new MainPage(driver).getMainPageHeader().clickHeaderMenuItem("Профіль");
    }
}
