package base.pages.item;

import base.core.PageTools;

import java.util.Objects;

public class Item extends PageTools {
    private String itemName;
    private String itemDescription;
    private String itemPrice;

    public Item() {
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemName, item.itemName) && Objects.equals(itemDescription, item.itemDescription) && Objects.equals(itemPrice, item.itemPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemDescription, itemPrice);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                '}';
    }
}
