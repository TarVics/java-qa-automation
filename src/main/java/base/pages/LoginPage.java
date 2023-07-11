package base.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginInput = $(By.xpath("//input[@placeholder='Username']"));
    private final SelenideElement passwordInput = $(By.xpath("//input[@placeholder='Password']"));
    private final SelenideElement loginButton = $(By.xpath("//input[@type='submit']"));

    public void typeUserName(String username) {
        loginInput.shouldBe(Condition.visible).append(username);
    }

    public void typePassword(String password) {
        passwordInput.shouldBe(Condition.visible).append(password);
    }
    public void clickLoginButton() {
        loginButton.shouldBe(Condition.enabled).click();
    }


}
