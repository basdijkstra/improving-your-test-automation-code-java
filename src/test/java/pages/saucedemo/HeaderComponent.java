package pages.saucedemo;

import com.microsoft.playwright.Page;

public class HeaderComponent {

    private Page page;

    public HeaderComponent(Page page) {

        this.page = page;
    }

    public void gotoShoppingCart() {

        this.page.locator("[data-test=shopping-cart-link]").click();
    }
}
