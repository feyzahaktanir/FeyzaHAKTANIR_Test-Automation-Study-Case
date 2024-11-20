package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.RequestBodyLoader;
import utilities.TestBaseClass;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class POST_CreateUser {
    private final TestBaseClass testBaseClass;

    private static final String BODY_FILE_PATH = "case-text/POST_CreateUser";
    public POST_CreateUser() {
        this.testBaseClass = TestBaseClass.getInstance();
    }
    public Response postCreateUser(String firstName, String lastName, String username, String password) throws IOException {
        RequestBodyLoader loader = new RequestBodyLoader(BODY_FILE_PATH);
        Map<String, String> replacements = Map.of(
                "firstName", firstName != null ? firstName : "null",
                "lastName", lastName != null ? lastName : "null",
                "username", username != null ? username : "null",
                "password", password != null ? password : "null"
        );
        String requestBody = loader.loadAndReplace(replacements);
        if (requestBody == null || requestBody.trim().isEmpty()) {
            throw new IllegalStateException("Request body is null or empty. Please check the file content and placeholders.");
        }

        Response response = given()
                .contentType(ContentType.JSON)
                .headers(testBaseClass.getHeaders())
                .body(requestBody)
                .when()
                .post(testBaseClass.getUserEndpoint())
                .then()
                .log().all()
                .extract()
                .response();
        response.prettyPrint();

        TestBaseClass.setResponse(response);

        return response;
    }
}
