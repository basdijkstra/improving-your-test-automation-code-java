package exercises;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.restassured.http.ContentType;
import loans.LoanRequest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@WireMockTest(httpPort = 9876)
public class Exercises04Test {

    @ParameterizedTest
    @CsvSource({
            "1000, 100, Approved",
            "10000, 100, Denied",
            "5000, 500, Approved"
    })
    public void applyFor1000DollarLoan_with100DownPayment_shouldBeApproved
            (int amount, int downPayment, String expectedResult) {

        LoanRequest loanRequest = new LoanRequest(amount, downPayment, "John", "Doe");

        given()
                .contentType(ContentType.JSON)
                .body(loanRequest)
                .when()
                .post("http://localhost:9876/loanApplication")
                .then()
                .statusCode(200)
                .body("result", equalTo(expectedResult));
    }
}
