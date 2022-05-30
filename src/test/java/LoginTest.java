import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPage;
import pageobjects.ProfilePage;

public class LoginTest extends BaseTest {

    @Test
    public void test1(){
        ProfilePage profilePage = new MainPage(driver).openProfilePage();

        Assert.assertTrue(profilePage.isTitleVisible(), "Title is not displayed");
    }
}
