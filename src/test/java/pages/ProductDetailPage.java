package pages;

import com.microsoft.playwright.Page;

public class ProductDetailPage extends BasePage{

    private final Page page;

    public ProductDetailPage(Page page) {

        super(page);
        this.page = page;
    }

    public ProductDetailPage addProductToCart() {

        this.page.getByText("Add to cart").click();
        return this;
    }
}
