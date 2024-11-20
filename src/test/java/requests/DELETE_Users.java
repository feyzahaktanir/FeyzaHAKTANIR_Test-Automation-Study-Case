package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.TestBaseClass;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DELETE_Users {

    private final TestBaseClass testBaseClass;
    public DELETE_Users() {
        this.testBaseClass = TestBaseClass.getInstance();
    }

    public Response deleteUsersById(String userId) throws IOException {

        Response response = given()
                .contentType(ContentType.JSON)
                .headers(testBaseClass.getHeaders())
                .when()
                .delete(testBaseClass.getUserEndpoint()+ "/" + userId)
                .then()
                .log().all()
                .extract()
                .response();
        response.prettyPrint();

        TestBaseClass.setResponse(response);

        return response;
    }
}
