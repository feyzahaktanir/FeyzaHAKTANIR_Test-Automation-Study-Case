package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.RequestBodyLoader;
import utilities.TestBaseClass;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PUT_UpdateUsers {
    private final TestBaseClass testBaseClass;

    private static final String BODY_FILE_PATH = "case-text/PUT_UpdateUser";
    public PUT_UpdateUsers() {
        this.testBaseClass = TestBaseClass.getInstance();
    }
    public Response putUpdateUser(String firstName, String lastName, String userId) throws IOException {
        RequestBodyLoader loader = new RequestBodyLoader(BODY_FILE_PATH);
        Map<String, String> replacements = Map.of(
                "firstName", firstName != null ? firstName : "null",
                "lastName", lastName != null ? lastName : "null"
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
                .post(testBaseClass.getUserEndpoint() + "/" + userId)
                .then()
                .log().all()
                .extract()
                .response();
        response.prettyPrint();

        TestBaseClass.setResponse(response);

        return response;
    }
}
