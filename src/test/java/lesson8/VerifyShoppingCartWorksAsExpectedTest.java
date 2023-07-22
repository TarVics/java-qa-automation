package lesson8;

import base.config.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static base.Pages.*;

public class VerifyShoppingCartWorksAsExpectedTest extends BaseTest {
    @BeforeMethod
    public void login(){
        loginPage().typeUserName("standard_user");
        loginPage().typePassword("secret_sauce");
        loginPage().clickLoginButton();
    }

    @Test
    public void shoppingCardTest(){
        mainPage().waitMainPageLogo(1500);

        List<String> mainPageItemsText = mainPage().getMainPageItemsText();

        while (mainPage().getAddToCartList().size() > 0){
            mainPage().clickAddToShoppingCardButton();
        }

        mainPage().clickShoppingCardButton();

        Selenide.sleep(500);

        List<String> shoppingCardElementsText = shoppingCardPage().getShoppingCardElementsText();

        Assert.assertEquals(mainPageItemsText, shoppingCardElementsText);
    }
}
