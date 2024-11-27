package pages.parabank;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AccountsOverviewPage {

    private final Page page;

    public AccountsOverviewPage(Page page) {

        this.page = page;
    }

    public void selectMenuItem(String menuItem) {

        this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(menuItem)).click();
    }
}
