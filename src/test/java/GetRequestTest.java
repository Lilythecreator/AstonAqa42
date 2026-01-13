import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.basePath = "/get";

        RestAssured.requestSpecification = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2");
    }

    @Test
    void statusCodeIs200() {
        given()
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test
    void argsAreCorrect() {
        given()
                .when()
                .get()
                .then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }
}