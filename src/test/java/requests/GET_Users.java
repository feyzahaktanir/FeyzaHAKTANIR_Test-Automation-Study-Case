package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.TestBaseClass;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GET_Users {

    private final TestBaseClass testBaseClass;
    public GET_Users() {
        this.testBaseClass = TestBaseClass.getInstance();
    }

    public Response getUsers() throws IOException {

        Response response = given()
                .contentType(ContentType.JSON)
                .headers(testBaseClass.getHeaders())
                .when()
                .get(testBaseClass.getUserEndpoint())
                .then()
                .log().all()
                .extract()
                .response();
        response.prettyPrint();

        return response;
    }


    public Response getUsersById(String userId) throws IOException {

        Response response = given()
                .contentType(ContentType.JSON)
                .headers(testBaseClass.getHeaders())
                .when()
                .get(testBaseClass.getUserEndpoint()+ "/" + userId)
                .then()
                .log().all()
                .extract()
                .response();
        response.prettyPrint();

        TestBaseClass.setResponse(response);

        return response;
    }
}
