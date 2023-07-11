package lesson4;

import com.codeborne.selenide.Condition;
import base.config.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ConditionTest extends BaseTest {

    @Test
    public void test() {
    //CHECKBOXES CHECK
//        SelenideElement checkbox = $(By.xpath("//input[2]"));
//        SelenideElement checkbox2 = $(By.xpath("//input[3]"));
//
//        checkbox.shouldBe(Condition.visible).click();
//
//        Assert.assertTrue(checkbox.is(Condition.checked)); // true
//        Assert.assertFalse(checkbox2.is(Condition.checked)); // false

//        ElementsCollection checkboxCollection = $$(By.xpath("//input[@type='checkbox']"));
//        checkboxCollection.shouldBe(CollectionCondition.size(100));
//        Assert.assertFalse(checkboxCollection.isEmpty());
//
//        for (int i = 0; i < checkboxCollection.size(); i++) {
//            checkboxCollection.get(i).click();
//            Assert.assertTrue(checkboxCollection.get(i).is(Condition.checked));
//        }


//        _____________________________________________
        $(By.xpath("//div[@class='login_logo']")).shouldBe(Condition.visible, Duration.ofMillis(3000));
//        $(By.xpath("//div[@class='login_logo']")).waitUntil(Condition.visible, 3000); // alternative method for wait

//        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.visible).append("standard_user");  // exist on site
        $(By.xpath("//input[@placeholder='Username']")).shouldHave(Condition.name("user-name")).append("standard_user");
//        $(By.xpath("//input[@placeholder='Username']")).shouldHave(Condition.cssClass("form_input")).append("standard_user");
//        $(By.xpath("//input[@placeholder='Username']")).shouldHave(Condition.id("user-name")).append("standard_user");
//        $(By.xpath("//input[@placeholder='Username']")).shouldHave(Condition.type("text")).append("standard_user");
//        $(By.xpath("//input[@placeholder='Username']")).shouldHave(Condition.attribute("data-test")).append("standard_user");
//        $(By.xpath("//input[@placeholder='Username']")).shouldHave(Condition.attribute("data-test", "username")).append("standard_user");


        $(By.xpath("//input[@placeholder='Password']")).shouldBe(Condition.empty).append("secret_sauce");  // exist on site
//        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.exist).append("asd");  // exist in DOM structure


//        $(By.xpath("asdada")).shouldBe(Condition.hidden, Duration.ofMillis(10000)); // wait until element disappears
        $(By.xpath("//input[@type='submit']")).shouldBe(Condition.enabled).click();

//        Selenide.sleep(3000); // not good variant, should be replaced with shouldBe and Duration


        String logoTextFromMainPage = $(By.xpath("//div[@class='app_logo']")).shouldBe(Condition.visible, Duration.ofMillis(3000)).shouldHave(Condition.text("labs")).text();

        Assert.assertEquals(logoTextFromMainPage, "Swag Labs");


        List<String> expectedTextsFromBurgerMenu = new ArrayList<>();

        expectedTextsFromBurgerMenu.add("All Items");
        expectedTextsFromBurgerMenu.add("About");
        expectedTextsFromBurgerMenu.add("Logout");
        expectedTextsFromBurgerMenu.add("Reset App State");

        $(By.xpath("//button[@id='react-burger-menu-btn']")).click();

        List<String> textsFromBurgerMenu = $$(By.xpath("//a[@class='bm-item menu-item']")).texts();

        Assert.assertEquals(expectedTextsFromBurgerMenu, textsFromBurgerMenu);

//        $(By.xpath("(//div[@class='inventory_item_name'])[1]")).shouldHave(Condition.text("backpack")).click();  // non case sensitivity
//        $(By.xpath("(//div[@class='inventory_item_name'])[1]")).shouldHave(Condition.exactText("sauce labs Backpack")).click(); // non case sensitivity

//        $(By.xpath("(//div[@class='inventory_item_name'])[1]")).shouldHave(Condition.textCaseSensitive("Backpack")).click();
//        $(By.xpath("(//div[@class='inventory_item_name'])[1]")).shouldHave(Condition.exactTextCaseSensitive("Sauce Labs Backpack")).click();

//        List<String> texts = $$(By.xpath("//div[@class='inventory_item_name']")).shouldHave(CollectionCondition.size(6)).texts();

//        List<String> texts = $$(By.xpath("//div[@class='inventory_item_name']")).shouldBe(CollectionCondition.empty).texts();

//        List<String> texts = $$(By.xpath("//div[@class='inventory_item_name']")).shouldBe(CollectionCondition.sizeNotEqual(7)).texts();
//        List<String> texts = $$(By.xpath("//div[@class='inventory_item_name']")).shouldBe(CollectionCondition.sizeLessThan(7)).texts();
//        List<String> texts = $$(By.xpath("//div[@class='inventory_item_name']")).shouldBe(CollectionCondition.sizeGreaterThan(5)).texts();
//        List<String> texts = $$(By.xpath("//div[@class='inventory_item_name']")).shouldBe(CollectionCondition.sizeLessThanOrEqual(10)).texts();
//        List<String> texts = $$(By.xpath("//div[@class='inventory_item_name']")).shouldBe(CollectionCondition.sizeGreaterThanOrEqual(4)).texts();


    }
}
