import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequestTest {


    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    void statusCodeIs200() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200);
    }
}
