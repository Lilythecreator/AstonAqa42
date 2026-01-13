import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutRequestTest {

    static String data;

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.basePath = "/put";

        data = "{"
                + "\"name\": \"Jane\","
                + "\"role\": \"Middle AQA\""
                + "}";
    }

    @Test
    void statusCodeIs200() {
        given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .put()
                .then()
                .statusCode(200);
    }

    @Test
    void bodyIsCorrect() {
        given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .put()
                .then()
                .body("json.name", equalTo("Jane"))
                .body("json.role", equalTo("Middle AQA"));
    }


}
