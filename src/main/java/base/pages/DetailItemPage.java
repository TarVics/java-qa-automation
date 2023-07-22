package base.pages;

import base.core.PageTools;
import base.pages.item.Item;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DetailItemPage extends PageTools {

    private final By detailItemHeader = By.xpath("//div[contains(@class, 'inventory_details_name')]");
    private final By detailItemDescription = By.xpath("(//div[contains(@class,'inventory_details_desc')])[2]");

    private final By detailItemPrice = By.xpath("//div[contains(@class, 'inventory_details_price')]");
    private final SelenideElement detailItemImg = $(By.xpath("//img[@class='inventory_details_img']"));
    private final By backToProductsBtn = By.xpath("//button[@id='back-to-products']");

    public void waitDetailPageImg() {
        //detailItemImg.waitUntil(Condition.visible, 5000);
        detailItemImg.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public String getDetailItemName() {
        return $(detailItemHeader).shouldBe(Condition.visible).text();
    }

    public String getDetailItemPrice() {
        return $(detailItemPrice).shouldBe(Condition.visible).text();
    }

    public Item getDetailItem() {
        Item item = new Item();
        item.setItemName(getElementText(detailItemHeader));
        item.setItemDescription(getElementText(detailItemDescription));
        item.setItemPrice(getElementText(detailItemPrice));
        return item;
    }

    public boolean isBackToProductsButtonExist() {
        return isElementExists(backToProductsBtn);
    }

}
