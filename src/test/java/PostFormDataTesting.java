import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostFormDataTesting {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.basePath = "/post";
        RestAssured.requestSpecification = given()
                .header("Content-Type", "application/form-data; charset=UTF-8")
                .formParam("msg1", "Hello")
                .formParam("msg2", "Testing");
    }

    @Test
    void statusCodeIs200() {
        given()
                .when()
                .post()
                .then()
                .statusCode(200);
    }

    @Test
    void formIsCorrect() {
        given()
                .when()
                .post()
                .then()
                .body("form.msg1", equalTo("Hello"))
                .body("form.msg2", equalTo("Testing"));
    }
}
