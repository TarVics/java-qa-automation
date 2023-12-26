package api.lesson10;

import base.pojoClasses.*;
import base.pojoClasses.innerJson.Pet;
import io.restassured.http.ContentType;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static base.pojoClasses.utils.Specifications.*;
import static io.restassured.RestAssured.given;

public class RestAssuredPojoTest {

    public static final String BASE_URL = "https://reqres.in/";

    @Test
    public void getDataTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));
        List<UserData> data = given()
                .when()
                .get("api/users?page=2")
                .then()
                .log().body().extract().body().jsonPath().getList("data", UserData.class);

        Assert.assertNotNull(data);

        List<String> avatars = new ArrayList<>();
        List<String> ids = new ArrayList<>();

        for (UserData datum : data) {
            Assert.assertTrue(datum.getEmail().contains("@reqres.in"));
            avatars.add(datum.getAvatar());
            ids.add(datum.getId().toString());
        }
        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test
    public void createUserTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(201));

        CreateUserRequest request = new CreateUserRequest();
        request.setName("morpheus");
        request.setJob("leader");

        CreateUserResponse createdUserResponse = given()
                .body(request)
                .when()
                .post("api/users")
                .then().log().body().extract().as(CreateUserResponse.class);

        Assert.assertEquals(request.getName(), createdUserResponse.getName());
    }

    @Test
    public void registerUserTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));

        int id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("eve.holt@reqres.in");
        registerRequest.setPassword("pistol");

        RegisterResponse registerResponse = given()
                .body(registerRequest)
                .when()
                .post("api/register")
                .then().log().body().extract().as(RegisterResponse.class);

        Assert.assertEquals(Integer.toString(id), registerResponse.getId().toString());
        Assert.assertEquals(token, registerResponse.getToken());
    }

    @Test
    public void updateUserTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));

        UpdateRequest updateRequest = new UpdateRequest("morpheus", "zion resident");

        UpdateResponse updateResponse = given()
                .body(updateRequest)
                .put("api/users/2")
                .then()
                .log().body()
                .extract().as(UpdateResponse.class);

        Assert.assertEquals(updateRequest.getName(), updateResponse.getName());
        Assert.assertEquals(updateRequest.getJob(), updateResponse.getJob());
    }
    @Test
    public void getPetTest(){

        Pet[] petResponse = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then()
                .statusCode(200)
                .log().body()
                .extract().as(Pet[].class);

        for (Pet pet : petResponse) {
            Assert.assertEquals(pet.getStatus(), "available");
        }
    }
}