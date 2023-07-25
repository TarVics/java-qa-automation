package gui.lesson6;

import base.config.BaseTest;
import org.testng.annotations.Test;

import static base.Pages.loginPage;

public class FrameworkTest extends BaseTest {

    @Test
    public void test(){
        loginPage().typeUserName("standard_user");
        loginPage().typePassword("secret_sauce");
        loginPage().clickLoginButton();
    }
}
