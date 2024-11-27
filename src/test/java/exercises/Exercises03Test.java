package exercises;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.parabank.AccountsOverviewPage;
import pages.parabank.LoginPage;
import pages.parabank.RequestLoanPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Exercises03Test {

    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeEach
    public void setUp() {

        this.playwright = Playwright.create();
        this.browser = this.playwright.chromium().launch();
        this.page = this.browser.newPage();
    }

    @Test
    public void submitALoanApplicationRequest() {

        new LoginPage(this.page)
                .open()
                .loginAs("john", "demo");

        new AccountsOverviewPage(this.page)
                .selectMenuItem("Request Loan");

        new RequestLoanPage(this.page)
                .submitLoanApplicationFor("1000", "100", "12345");

        assertThat(page.locator("#loanStatus")).isVisible();
        assertThat(page.locator("#loanStatus")).hasText("Approved");
    }

    @Test
    public void submitAnotherLoanApplicationRequest() {

        new LoginPage(this.page)
                .open()
                .loginAs("john", "demo");

        new AccountsOverviewPage(this.page)
                .selectMenuItem("Request Loan");

        new RequestLoanPage(this.page)
                .submitLoanApplicationFor("10000", "100", "12345");

        assertThat(page.locator("#loanStatus")).isVisible();
        assertThat(page.locator("#loanStatus")).hasText("Denied");
    }

    @Test
    public void submitYetAnotherLoanApplicationRequest() {

        new LoginPage(this.page)
                .open()
                .loginAs("john", "demo");

        new AccountsOverviewPage(this.page)
                .selectMenuItem("Request Loan");

        new RequestLoanPage(this.page)
                .submitLoanApplicationFor("5000", "500", "12345");

        assertThat(page.locator("#loanStatus")).isVisible();
        assertThat(page.locator("#loanStatus")).hasText("Approved");
    }

    @AfterEach
    public void tearDown() {

        this.browser.close();
        this.playwright.close();
    }
}
