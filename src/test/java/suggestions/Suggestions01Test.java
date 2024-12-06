package suggestions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.saucedemo.LoginPage;
import pages.saucedemo.ProductDetailPage;
import pages.saucedemo.ProductsOverviewPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Suggestions01Test {

    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeEach
    public void startPlaywrightSession() {

        this.playwright = Playwright.create();
        this.browser = this.playwright.chromium().launch();
        this.page = this.browser.newPage();
    }

    @Test
    public void orderABackpack() {

        new LoginPage(this.page)
                .open()
                .loginAs("standard_user", "secret_sauce");

        new ProductsOverviewPage(this.page)
                .selectProduct("Sauce Labs Backpack");

        new ProductDetailPage(this.page)
                .addProductToCart()
                .gotoShoppingCart();

        assertThat(this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Checkout"))).isVisible();
    }

    @AfterEach
    public void stopPlaywrightSession() {

        this.browser.close();
        this.playwright.close();
    }
}
