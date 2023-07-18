package lesson7;

import base.config.BaseTest;
import base.pages.item.Item;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static base.Pages.*;

public class VerifyDetailItemCorrespondingMainPageItemTest extends BaseTest {

    @BeforeMethod
    public void login(){
        loginPage().typeUserName("standard_user");
        loginPage().typePassword("secret_sauce");
        loginPage().clickLoginButton();
    }

    @Test
    public void detailItemTest(){
        mainPage().waitMainPageLogo(3000);

        List<Item> itemsFromMainPage = mainPage().getItems();

        System.out.println(itemsFromMainPage + " Items from main page");

        mainPage().getMainPageItems().get(1).click();

        Selenide.sleep(500);

        Item detailItem = detailItemPage().getDetailItem();

        System.out.println(detailItem + " Detail item");

        Assert.assertTrue(itemsFromMainPage.contains(detailItem));
    }
}
