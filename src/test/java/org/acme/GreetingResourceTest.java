package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.restassured.http.ContentType;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello from Quarkus REST"));
    }

    /**
     * Test case for converting kilometers to miles.
     *
     * This test sends a POST request to the "/Conversion/km-to-miles"
     * endpoint with a body of "50" (representing 50 kilometers per hour).
     * The expected result is a response with a status code of 200 and a
     * body of "31.06855" (the equivalent value in miles per hour).
     */
    @Test
    void testConversionKmMiles() {
        given()
                .contentType(ContentType.TEXT)
                // 50 quilômetros por hora
                .body("50")
                .when()
                .post("/Conversion/km-to-miles")
                .then()
                .contentType(ContentType.TEXT)
                .statusCode(200)
                .body(is("31.06856"));
    }

    /**
     * Test case to verify the conversion from knots to kilometers per hour.
     * The expected value for 1 knot in km/h is 1.852.
     */
    @Test
    void testConversionKnotsKm() {
        given()
                .contentType(ContentType.TEXT)
                .when()
                .contentType(ContentType.JSON)
                .get("/Conversion/knots-to-km/1")
                .then()
                .statusCode(200)
                .body("value", is(1.852f));
    }

}