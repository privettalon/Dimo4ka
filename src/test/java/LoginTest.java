import datamodels.UserDataModel;
import datamodels.UserDataModelConstructor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPage;
import pageobjects.ProfilePage;

public class LoginTest extends BaseTest {

    @Test
    public void test1(){
        UserDataModel superModel = UserDataModel.builder().username("kdsk").password("kdsks").build();

        ProfilePage profilePage = new MainPage(driver)
                .openProfilePage()
                .setEmail(superModel.getUsername());

        Assert.assertTrue(profilePage.isTitleVisible(), "Title is not displayed");
    }

    @Test(dependsOnMethods = "test1")
    public void test2(){
        UserDataModel superModel = UserDataModel.builder().username("kdsk").password("kdsks").build();

        ProfilePage profilePage = new MainPage(driver)
                .openProfilePage()
                .setEmail(superModel.getUsername());

        Assert.assertTrue(profilePage.isTitleVisible(), "Title is not displayed");
    }
}
