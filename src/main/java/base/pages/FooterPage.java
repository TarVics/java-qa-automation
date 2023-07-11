package base.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FooterPage {

    private final SelenideElement socialTwitter = $(By.xpath("//li[@class='social_twitter']//a"));
    private final SelenideElement socialFacebook = $(By.xpath("//li[@class='social_facebook']//a"));
    private final SelenideElement socialLinkedIn = $(By.xpath("//li[@class='social_linkedin']//a"));

    public void clickSocialTwitter() {
        socialTwitter.shouldBe(Condition.visible).click();
    }

    public void clickSocialFacebook() {
        socialFacebook.shouldBe(Condition.visible).click();
    }

    public void clickSocialLinkedIn() {
        socialLinkedIn.shouldBe(Condition.visible).click();
    }
}
