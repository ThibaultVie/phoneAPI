package fr.esgi.demo.web;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.springframework.http.HttpStatus;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

/**
 * Created by Thibault on 19/03/15.
 */
public class GameControllerTest {

    @Before
    public  void setUp() {
        RestAssured.port = 9000;
    }

    @Test
    public void should_GetOneGame(){

        given()
                    .log().all()
                .when()
                    .get("/game")
                .then()
                    .log().all()
                .statusCode(HttpStatus.OK.value())
                .body("id", is(1))
                .body("name", is("Dying light"))
                .body("type", is("FPS"));

    }
}
