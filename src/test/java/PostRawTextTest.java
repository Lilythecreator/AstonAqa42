import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRawTextTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.basePath = "/post";

        RestAssured.requestSpecification = given()
                .body("Hello world!");
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
    void dataIsCorrect() {
        given()
                .when()
                .post()
                .then()
                .body("data", equalTo("Hello world!"));
    }


}
