package gui.lesson3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import base.config.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorkWithElementsTest extends BaseTest {

    @BeforeTest
    public void download() {
        Configuration.fileDownload = FileDownloadMode.FOLDER;
    }

    @BeforeMethod
    public void setUp(){
//        Selenide.open("https://www.saucedemo.com/v1/");

        // https://www.stats.govt.nz/large-datasets/csv-files-for-download/ - URL TO DOWNLOAD FILE
//    https://ps.uci.edu/~franklin/doc/file_upload.html - URL TO UPLOAD FILE
        //https://checkcps.com/double-click/ - URL TO DOUBLE CLICK
//    "https://faculty.washington.edu/chudler/java/boxes.html" - URL WITH CHECKBOXES
//        https://www.youtube.com/ - CONTROL CHECK
        Selenide.open("https://owu.com.ua/");
    }


    public static String getFilePathByName(String fileName) {
        return new File("src/main/resources/files/" + fileName).getAbsolutePath();
    }

    @Test
    public void test() {
        Selenide.sleep(3000);

        $(By.xpath("//nav//div[1]")).hover();
        List<String> coursesList = $$(By.xpath("//nav//div[1]//a")).texts();
        System.out.println(coursesList);

        $(By.xpath("//nav//div[1]//a[text()='JavaScript']")).click();


//        $(By.xpath("(//h3//a)[1]")).scrollTo();
//
//        Selenide.sleep(2000);
//
//        try {
//            File download = $(By.xpath("(//h3//a)[1]")).download();
//            Selenide.sleep(5000);
//
//            String path = download.getPath();
//
//            System.out.println(path);
//
//            FileUtils.deleteDirectory(new File("build/downloads"));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        $(By.xpath("asd")).doubleClick();
//        ElementsCollection checkboxesCollection = $$(By.xpath("//input[@type='checkbox']"));
//        for (int i = 0; i <= checkboxesCollection.size(); i++) {
//            checkboxesCollection.get(i).click();
//        }
//        $(By.xpath("//input[1]")).uploadFile(new File(getFilePathByName("annual-enterprise-survey-2021-financial-year-provisional-csv.csv")));

//        $(By.xpath("//input[@placeholder='Username']")).append("standard_user");
//        $(By.xpath("//input[@placeholder='Password']")).append("secret_sauce");

//        $(By.xpath("//input[@type='submit']")).submit();
//        $(By.xpath("//input[@type='submit']")).click();

//        Selenide.actions().sendKeys(Keys.ENTER).perform();
//
//        Selenide.sleep(1000);
//
//        $(By.xpath("//select[@class='product_sort_container']")).click();

//        String optionText = $(By.xpath("//option[2]")).text();
//        List<String> optionTexts = $$(By.xpath("//option")).texts();
//
//        System.out.println(optionTexts);
//        System.out.println(optionText);

//        Selenide.actions().sendKeys(Keys.ESCAPE).perform();


//        ElementsCollection mainItems = $$(By.xpath("//div[@class='inventory_item_name']"));
//        $(By.xpath("(//div[@class='inventory_item_name'])[2]")).click();

//        mainItems.get(1).click();
//
//        Selenide.actions().keyDown($(By.xpath("from element")), Keys.SHIFT).perform();
//
//        Selenide.actions().keyUp($(By.xpath("to element")), Keys.SHIFT).perform();


//        $(By.xpath("//*[@id='logo-icon']//div")).click();

//        Selenide.actions().keyDown($(By.xpath("//*[@id='logo-icon']//div")), Keys.LEFT_CONTROL).perform();
//
//        $(By.xpath("//*[@id='logo-icon']//div")).click();
//
//        Selenide.actions().keyUp(Keys.LEFT_CONTROL).perform();


    }

}
