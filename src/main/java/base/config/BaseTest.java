package base.config;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest(alwaysRun = true)// Run even after an error occurred
    public void config() {
        // Setup Web Browser
        Configuration.browser = Browsers.FIREFOX;
        // Configuration.browser = "chrome";

        // Set Browser window maximized (DEPRECATED)
        // Configuration.startMaximized = true;

        // Instead "Configuration.startMaximized" use folow code:
        // Selenide.open();
        // getWebDriver().manage().window().maximize();

        // Unattended mode. Invisible window. Do not use with maximize window
        Configuration.headless = false;

        // Browser window size
        // Configuration.browserSize = "300x200";

        // Browser opened after all tests
        Configuration.holdBrowserOpen = true;

        // Wait time for searching an element on page
        Configuration.timeout = 10000;


        /*
            Should webdriver wait until page is completely loaded. Possible values: "none", "normal" and "eager".
                Can be configured either programmatically, via selenide.properties file or by system property
                "-Dselenide.pageLoadStrategy=eager". Default value: "normal".
                - `normal`: return after the load event fires on the new page (it's default in Selenium webdriver);
                - `eager`: return after DOMContentLoaded fires;
                - `none`: return immediately
            In some cases `eager` can bring performance boosts for the slow tests.
            Though, we left default value `normal` because we are afraid to break users' existing tests.
        */
        Configuration.pageLoadStrategy = "normal";

        // In case unsuccessful tests in /build/reports/tests
        Configuration.screenshots = true;

        // In case error will save html sources of pages in /build/reports/tests
        Configuration.savePageSource = false;

        // Web page load timeout
        Configuration.pageLoadTimeout = 10000;


        Configuration.holdBrowserOpen = false; // FOR JENKINS NEED HIDDEN WINDOW !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Configuration.headless = true; // FOR JENKINS NEED HEADLESS WINDOW !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    @BeforeMethod
    public void setUp(){
//        Selenide.open("https://www.saucedemo.com/v1/");
        Selenide.open("https://www.saucedemo.com");
    }

/*
    @AfterMethod(alwaysRun = true) // Run even after an error occurred
    public void cleanWebDriver(){
        Selenide.clearBrowserCookies();
        Selenide.refresh();
        Selenide.open("about:blank");
    }

    @AfterClass
    public void tearDown() {
        // Selenide.closeWebDriver();
        Selenide.closeWindow();
    }
*/


}
