package exercises;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource({
            "1000, 100, Approved",
            "10000, 100, Denied",
            "5000, 500, Approved"
    })
    public void submitALoanApplicationRequest
            (String amount, String downPayment, String expectedResult) {

        new LoginPage(this.page)
                .open()
                .loginAs("john", "demo");

        new AccountsOverviewPage(this.page)
                .selectMenuItem("Request Loan");

        new RequestLoanPage(this.page)
                .submitLoanApplicationFor(amount, downPayment, "12345");

        assertThat(page.locator("#loanStatus")).isVisible();
        assertThat(page.locator("#loanStatus")).hasText(expectedResult);
    }

    @AfterEach
    public void tearDown() {

        this.browser.close();
        this.playwright.close();
    }
}
