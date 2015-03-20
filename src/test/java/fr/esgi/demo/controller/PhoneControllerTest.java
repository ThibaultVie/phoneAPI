package fr.esgi.demo.controller;


import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PhoneControllerTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "localhost";
        RestAssured.port = 9000;
    }

    @Test
    public void shouldGetPhones() {
        given()
            .log().all()
        .when()
            .get("/phone")
        .then()
            .log().all()
            .statusCode(200);
    }

    @Test
    public void shouldGetOnePhone() {
        Long phoneId = 1L;

        given()
            .log().all()
        .when()
            .get("/phone/{phoneId}", phoneId)
        .then()
            .log().all()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void shouldDeleteOnephone() {
        Long phoneId = 1L;

        given()
            .log().all()
        .when()
            .delete("/phone", phoneId)
        .then()
            .log().all()
            .body("id", is(1));
    }

    @Test
    public void shouldCreateOnePhone() {
        Long phoneId = 1L;

        given()
                .param("serialNumber", "123")
                .param("number", "456")
                .param("firstname", "Tvie")
                .param("lastname","Vie")
                .param("Stolen", true)
            .log().all()
        .when()
            .post("/phone")
        .then()
            .log().all()
            .body("serialNumber", is("123"))
            .body("number", is("456"))
                .body("firstname", is("Tvie"))
                .body("lastname", is("Tvie"))
                .body("firstname", is("Vie"))
                .body("Stolen", is(true));

    }

}

