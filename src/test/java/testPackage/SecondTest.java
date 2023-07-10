package testPackage;

import org.testng.annotations.*;

public class SecondTest {
    @Test
    public void test() {
        System.out.println(">>>>> 1 Our second test");
    }

    @Test
    public void test2() {
        System.out.println(">>>>> 2 Our second another test");
    }

    @BeforeSuite // Runs Before All tests in a suite
    public void testBeforeSuite() {
        System.out.println("This is BeforeSuite annotation");
    }

    @AfterSuite // Runs After All tests in a suite
    public void testAfterSuite() {
        System.out.println("This is AfterSuite annotation");
    }

    @BeforeTest // Runs Before First method with tests
    public void testBeforeTest() {
        System.out.println("This is BeforeTest annotation");
    }

    @AfterTest // Runs After Last method with tests
    public void testAfterTest() {
        System.out.println("This is AfterTest annotation");
    }

    @BeforeClass // Runs Before All tests in a class
    public void testBeforeClass() {
        System.out.println("This is BeforeClass annotation");
    }

    @AfterClass // Runs Before All tests in a class
    public void testAfterClass() {
        System.out.println("This is AfterClass annotation");
    }

    @BeforeMethod // Runs Before a test method
    public void testBeforeMethod() {
        System.out.println("This is BeforeMethod annotation");
    }

    @AfterMethod // Runs After a test method
    public void testAfterMethod() {
        System.out.println("This is AfterMethod annotation");
    }


}
