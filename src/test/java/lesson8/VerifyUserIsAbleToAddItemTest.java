package lesson8;

import base.config.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.Pages.*;

public class VerifyUserIsAbleToAddItemTest extends BaseTest {

    @BeforeMethod
    public void login(){
        loginPage().typeUserName("standard_user");
        loginPage().typePassword("secret_sauce");
        loginPage().clickLoginButton();
    }

    @Test
    public void addItemTest(){
        mainPage().waitMainPageLogo(1500);

        mainPage().clickItemByName("Sauce Labs Fleece Jacket");

        detailItemPage().waitDetailPageImg();

        Assert.assertTrue(detailItemPage().isBackToProductsButtonExist());

    }
}
