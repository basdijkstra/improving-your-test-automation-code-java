package pages.saucedemo;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page) {

        this.page = page;
    }

    public LoginPage open() {

        this.page.navigate("https://www.saucedemo.com/");
        return this;
    }

    public void loginAs(String username, String password) {

        this.page.getByPlaceholder("Username").fill(username);
        this.page.getByPlaceholder("Password").fill(password);
        this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
