import datamodels.UserDataModel;
import datamodels.UserDataModelConstructor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.MainPage;
import pageobjects.ProductPage;
import pageobjects.ProfilePage;


public class AddToCartTest extends BaseTest{

    @Test
    public  void Test1(){
        ProductPage productPage= new MainPage(driver).openCatalogClick();
        CartPage cartPage = productPage
                .openCartPage();

        Assert.assertNull(cartPage.emptyCart);
    }
}
