package base.pages;

import base.core.PageTools;
import org.openqa.selenium.By;

import java.util.List;

public class ShoppingCardPage extends PageTools {
    private final By shoppingCardItems = By.xpath("//div[@class='cart_item_label']//div[@class='inventory_item_name']");

    public List<String> getShoppingCardElementsText(){
       return getElementsText(shoppingCardItems);
    }
}
