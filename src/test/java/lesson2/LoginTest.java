package lesson2;

import base.config.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest {
    @Test
    public void test(){
//        $(By.tagName("input")).append("asdas");
//        $(By.tagName("input")).append("asdas");
//        $(By.id("user-name")).append("asdasd");
//        $(By.name("password")).append("asd");
//        $(By.className("btn_action")).click();
        $(By.xpath("//input[@id='user-name']")).append("standard_user");
        $(By.xpath("//input[@placeholder='Password']")).append("secret_sauce");
        $(By.xpath("//input[@value='LOGIN']")).click();

        $(By.xpath("//input[@placeholder='Password']")).setValue("secret_sauce");

        $(By.xpath("(//div[@class='inventory_item']//div[@class='inventory_item_name'])[4]")).click();
    }
}
