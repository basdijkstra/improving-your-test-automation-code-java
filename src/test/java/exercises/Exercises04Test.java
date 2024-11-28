package exercises;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@WireMockTest(httpPort = 9876)
public class Exercises04Test {

    @Test
    public void applyFor1000DollarLoan_with100DownPayment_shouldBeApproved() {

        String requestBody = """
                {
                    "loanAmount": 1000,
                    "downPayment": 100,
                    "firstName": "John",
                    "lastName" : "Doe"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:9876/loanApplication")
                .then()
                .statusCode(200)
                .body("result", equalTo("Approved"));
    }

    @Test
    public void applyFor10000DollarLoan_with100DownPayment_shouldBeDenied() {

        String requestBody = """
                {
                    "loanAmount": 10000,
                    "downPayment": 100,
                    "firstName": "John",
                    "lastName" : "Doe"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:9876/loanApplication")
                .then()
                .statusCode(200)
                .body("result", equalTo("Denied"));
    }

    @Test
    public void applyFor5000DollarLoan_with500DownPayment_shouldBeApproved() {

        String requestBody = """
                {
                    "loanAmount": 5000,
                    "downPayment": 500,
                    "firstName": "John",
                    "lastName" : "Doe"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:9876/loanApplication")
                .then()
                .statusCode(200)
                .body("result", equalTo("Approved"));
    }
}
