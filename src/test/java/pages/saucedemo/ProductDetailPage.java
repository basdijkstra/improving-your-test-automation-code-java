package pages.saucedemo;

import com.microsoft.playwright.Page;

public class ProductDetailPage {

    private final Page page;

    public ProductDetailPage(Page page) {

        this.page = page;
    }

    public ProductDetailPage addProductToCart() {

        this.page.getByText("Add to cart").click();
        return this;
    }
}
