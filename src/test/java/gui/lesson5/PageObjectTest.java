package gui.lesson5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

import base.config.BaseTest;
import base.pages.BurgerMenuPage;
import static base.Pages.*;

public class PageObjectTest extends BaseTest {
    BurgerMenuPage burgerMenuPage = new BurgerMenuPage();
    @Test
    public void test() {

        loginPage().typeUserName("standard_user");
        loginPage().typePassword("secret_sauce");
        loginPage().clickLoginButton();

        mainPage().wainUntilMainPageLoad();

        System.out.println(mainPage().getMainPageItemsText());


        mainPage().clickBurgerMenu();

        Selenide.sleep(1000);

        List<String> expectedTextsFromBurgerMenu = new ArrayList<>();
        expectedTextsFromBurgerMenu.add("All Items");
        expectedTextsFromBurgerMenu.add("About");
        expectedTextsFromBurgerMenu.add("Logout");
        expectedTextsFromBurgerMenu.add("Reset App State");

        System.out.println(burgerMenuPage.getBurgerMenuItemsTexts());

        Assert.assertEquals(expectedTextsFromBurgerMenu, burgerMenuPage.getBurgerMenuItemsTexts());

        burgerMenuPage.clickCloseBurgerMenuButton();

        footerPage().clickSocialFacebook();

        Selenide.switchTo().window(1);

        Selenide.sleep(5000);

//        $(By.xpath("//div[@aria-label='Close']")).shouldBe(Condition.visible).click();
        $(By.xpath("//div[@aria-label='Закрити']")).shouldBe(Condition.visible).click();

        Assert.assertTrue($(By.xpath("//h1[text()='Sauce Labs']")).is(Condition.visible));

        WebDriver webDriver = WebDriverRunner.getWebDriver(); // extract web driver in selenide

        Set<String> windowHandles = webDriver.getWindowHandles();

        Assert.assertEquals(windowHandles.size(), 2);

        Selenide.closeWindow();

        Selenide.switchTo().window(0);

        mainPage().getMainPageItems().get(2).click();

        detailItemPage().waitDetailPageImg();

        System.out.println(detailItemPage().getDetailItemName() + " - " + detailItemPage().getDetailItemPrice());
    }
}
