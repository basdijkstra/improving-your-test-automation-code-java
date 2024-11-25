package exercises;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Exercises01Test {

    @Test
    public void orderABackpack() {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch();

        Page page = browser.newPage();

        page.navigate("https://www.saucedemo.com/");

        page.getByPlaceholder("Username").fill("standard_user");
        page.getByPlaceholder("Password").fill("secret_sauce");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        page.getByText("Sauce Labs Backpack").click();
        page.getByText("Add to cart").click();

        page.locator("[data-test=shopping-cart-link]").click();

        assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Checkout"))).isVisible();

        browser.close();
        playwright.close();
    }
}
