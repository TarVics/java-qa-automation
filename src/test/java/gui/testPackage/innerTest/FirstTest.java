package gui.testPackage.innerTest;

import base.config.BaseTest;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$;

public class FirstTest extends BaseTest {

    @BeforeTest
    @Test(description = "TEST-25: Verify user is able to open URL of google.com", priority = 2)
    public void test() {
        System.out.println(">>>>> Opening https://www.google.com/");
//        Selenide.open("https://www.google.com/");
//        $(By.xpath("ssss")).click();
//        Thread.sleep(5000);
//        Selenide.sleep(5000);
    }

    //@Test(dependsOnMethods = "test") // Runs if "test" method succeeded
    @Test(priority = 1)
    public void test2() {
        System.out.println(">>>>> Opening test2");
    }

}
