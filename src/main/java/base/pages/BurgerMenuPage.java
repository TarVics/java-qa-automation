package base.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BurgerMenuPage {

    private final ElementsCollection burgerMenuItems = $$(By.xpath("//a[contains(@class,'bm-item')]"));
    private final SelenideElement closeBurgerMenuButton = $(By.xpath("//button[@id='react-burger-cross-btn']"));

    public List<String> getBurgerMenuItemsTexts(){
        return burgerMenuItems.shouldBe(CollectionCondition.size(4)).texts();
    }
    public ElementsCollection getBurgerMenuItems(){
        return burgerMenuItems.shouldBe(CollectionCondition.size(4));
    }
    public void clickCloseBurgerMenuButton(){
        closeBurgerMenuButton.shouldBe(Condition.visible).click();
    }
}
