package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200);
    }

    @Test
    void matchesJsonSchemaInClasspathTest() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }

    @Test
    void shouldChangeTheIdType() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .body("[0].id", equalTo(1));

    }
    @Test
    void HeaderTest() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=UTF-8");
    }

    @Test
    void currencyRubTest() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .body("[0].currency", equalTo("RUB"));
    }

    @Test
    void currencyRurTest() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .body("[0].currency", equalTo("RUR"));
    }

    @Test
    void shouldNegativeTest() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(400);
    }


}
