package base;

import base.pages.*;

public class Pages {

    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static DetailItemPage detailItemPage;
    private static FooterPage footerPage;
    private static ShoppingCardPage shoppingCardPage;

    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
    public static MainPage mainPage(){
        if (mainPage == null){
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public static DetailItemPage detailItemPage() {
        if (detailItemPage == null) {
            detailItemPage = new DetailItemPage();
        }
        return detailItemPage;
    }

    public static FooterPage footerPage() {
        if (footerPage == null) {
            footerPage = new FooterPage();
        }
        return footerPage;
    }

    public static ShoppingCardPage shoppingCardPage() {
        if (shoppingCardPage == null) {
            shoppingCardPage = new ShoppingCardPage();
        }
        return shoppingCardPage;
    }

}
