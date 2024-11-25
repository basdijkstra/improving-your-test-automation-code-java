package pages;

import com.microsoft.playwright.Page;

public class BasePage {

    private final Page page;

    protected BasePage(Page page) {

        this.page = page;
    }

    public void gotoShoppingCart() {

        this.page.locator("[data-test=shopping-cart-link]").click();
    }
}
