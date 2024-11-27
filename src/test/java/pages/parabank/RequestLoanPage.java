package pages.parabank;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class RequestLoanPage {

    private final Page page;

    public RequestLoanPage(Page page) {

        this.page = page;
    }

    public void submitLoanApplicationFor(String amount, String downPayment, String fromAccountId) {

        this.page.locator("#amount").fill(amount);
        this.page.locator("#downPayment").fill(downPayment);
        this.page.locator("#fromAccountId").selectOption(fromAccountId);
        this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply Now")).click();
    }
}