package base.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DetailItemPage {

    private final SelenideElement detailItemHeader = $(By.xpath("//div[contains(@class, 'inventory_details_name')]"));
    private final SelenideElement detailItemPrice = $(By.xpath("//div[contains(@class, 'inventory_details_price')]"));
    private final SelenideElement detailItemImg = $(By.xpath("//img[@class='inventory_details_img']"));

    public void waitDetailPageImg() {
        //detailItemImg.waitUntil(Condition.visible, 5000);
        detailItemImg.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public String getDetailItemName() {
        return detailItemHeader.shouldBe(Condition.visible).text();
    }

    public String getDetailItemPrice() {
        return detailItemPrice.shouldBe(Condition.visible).text();
    }
}
