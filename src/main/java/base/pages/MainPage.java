package base.pages;

import base.core.PageTools;
import base.pages.item.Item;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends PageTools {
    private final ElementsCollection itemNames = $$(By.xpath("//div[@class='inventory_item_name']"));
    private final SelenideElement mainPageLogo = $(By.xpath("//div[@class='app_logo']"));
    private final SelenideElement burgerMenuButton = $(By.xpath("//button[@id='react-burger-menu-btn']"));

    private final By elementNames = By.xpath("//div[@class='inventory_item_name']");
    private final By elementDescriptions = By.xpath("//div[@class='inventory_item_desc']");
    private final By elementPrices = By.xpath("//div[@class='inventory_item_price']");
    private final By mainPageLogotype = By.xpath("//div[@class='app_logo']");

    public ElementsCollection getMainPageItems() {
        return itemNames.shouldBe(CollectionCondition.size(6));
    }

    public List<String> getMainPageItemsText() {
        return itemNames.shouldBe(CollectionCondition.size(6)).texts();
    }
    public void wainUntilMainPageLoad(){
        System.out.println(mainPageLogo.shouldBe(Condition.visible, Duration.ofMillis(5000)));
        System.out.println(burgerMenuButton.shouldBe(Condition.visible, Duration.ofMillis(5000)));
    }

    public void clickBurgerMenu() {
        burgerMenuButton.shouldBe(Condition.visible).click();
    }

    public List<Item> getItems() {
        List<Item> itemList = new ArrayList<>();

        List<String> nameList = getElementsText(elementNames);
        List<String> descriptionList = getElementsText(elementDescriptions);
        List<String> pricesList = getElementsText(elementPrices);

        for (int i = 0; i < nameList.size(); i++) {
            Item item = new Item();
            item.setItemName(nameList.get(i));
            item.setItemDescription(descriptionList.get(i));
            item.setItemPrice(pricesList.get(i));
            itemList.add(item);
        }
        return itemList;
    }

    public void waitMainPageLogo(int time){
        waitUntilElementVisibility(mainPageLogotype, time);
    }
}
