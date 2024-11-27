package pages.parabank;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page) {

        this.page = page;
    }

    public LoginPage open() {

        this.page.navigate("https://parabank.parasoft.com/");
        return this;
    }

    public void loginAs(String username, String password) {

        this.page.locator("[name=username]").fill(username);
        this.page.locator("[name=password]").fill(password);
        this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
    }
}
