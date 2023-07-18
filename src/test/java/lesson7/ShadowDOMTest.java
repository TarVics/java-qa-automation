package lesson7;

import base.config.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clipboard;

public class ShadowDOMTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        Selenide.open("http://uitestingplayground.com/shadowdom");
    }

    @Test
    public void shadowTest(){
        Selenide.sleep(3000);

        $(shadowCss("#buttonGenerate", "guid-generator")).click();

        $(shadowCss("#buttonCopy", "guid-generator")).click();

        String textsFromClipboard = clipboard().getText();


        String inputText = $(shadowCss("#editField", "guid-generator")).getValue();


        Assert.assertNotEquals(textsFromClipboard, inputText);

    }
}
