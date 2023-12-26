package api.lesson9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest {
    public static final String BASE_URL = "https://reqres.in/";

    // ______________________________GET____________________________
    @Test(description = "Test GET", priority = 1)
    public void testGet() {
        Response response = RestAssured.get(BASE_URL + "api/users?page=2");
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());

        System.out.println(response.getStatusCode());

        given()
                .get(BASE_URL + "api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(7));

        given()
                .get(BASE_URL + "api/users?page=2")
                .then()
                .statusCode(200)
                .log().body();

        Response response2 = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + "api/users?page=2")
                .then()
                .extract().response();

        Assert.assertEquals(200, response2.getStatusCode());
        Assert.assertEquals("Lindsay", response2.jsonPath().getString("data[1].first_name"));
    }

    //        _____________________________________POST_________________________________________
    @Test(description = "Test POST", priority = 2)
    public void testPost() {

        Map<String, String> map = new HashMap<>();

        map.put("name", "Marian");
        map.put("job", "aqa");

        given()
                .header("Content-Type", "application/json")
                .accept(ContentType.JSON)
                .body(map)
                .when()
                .post(BASE_URL + "api/users")
                .then()
                .statusCode(201).log().body();
    }

    //        ______________________________________________PUT_______________________________________________
    @Test(description = "Test PUT", priority = 3)
    public void testPut() {

        JSONObject request = new JSONObject();
        request.put("name", "Marian");
        request.put("job", "aqa");

        given()
                .header("Content-Type", "application/json")
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put(BASE_URL + "api/users/2")
                .then()
                .statusCode(200).log().body();
    }

    //        __________________________________________DELETE__________________________________________________
    @Test(description = "Test DELETE", priority = 4)
    public void testDelete() {

        when()
                .delete(BASE_URL + "api/users/2")
                .then()
                .statusCode(204).log().all();
    }
}

