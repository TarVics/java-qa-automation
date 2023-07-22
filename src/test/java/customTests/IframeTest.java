package customTests;

import base.config.BaseTest;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class IframeTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        Selenide.open("https://demoqa.com/frames");
    }

    @Test
    public void iframeTest(){
        Selenide.sleep(3000);

        Selenide.switchTo().frame("frame1");

        System.out.println($(By.xpath("//h1[1]")).text());

        Selenide.switchTo().defaultContent();

        Selenide.switchTo().frame("frame2");

        System.out.println($(By.xpath("//h1[1]")).text());
    }
}
