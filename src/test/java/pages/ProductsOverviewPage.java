package pages;

import com.microsoft.playwright.Page;

public class ProductsOverviewPage {

    private final Page page;

    public ProductsOverviewPage(Page page) {

        this.page = page;
    }

    public void selectProduct(String productName) {

        this.page.getByText(productName).click();
    }
}
