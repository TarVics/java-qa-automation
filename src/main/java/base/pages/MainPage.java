package base.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final ElementsCollection itemNames = $$(By.xpath("//div[@class='inventory_item_name']"));
    private final SelenideElement mainPageLogo = $(By.xpath("//div[@class='app_logo']"));
    private final SelenideElement burgerMenuButton = $(By.xpath("//button[@id='react-burger-menu-btn']"));

    public ElementsCollection getMainPageItems() {
        return itemNames.shouldBe(CollectionCondition.size(6));
    }

    public List<String> getMainPageItemsText() {
        return itemNames.shouldBe(CollectionCondition.size(6)).texts();
    }
    public void wainUntilMainPageLoad(){
        mainPageLogo.shouldBe(Condition.visible, Duration.ofMillis(5000));
    }
    public void clickBurgerMenu(){
        burgerMenuButton.shouldBe(Condition.visible).click();
    }
}
