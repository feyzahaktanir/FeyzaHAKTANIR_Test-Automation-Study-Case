package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.RequestBodyLoader;
import utilities.TestBaseClass;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PATCH_Users {
    private final TestBaseClass testBaseClass;

    private static final String BODY_FILE_PATH = "case-text/PATCH_Users";
    public PATCH_Users() {
        this.testBaseClass = TestBaseClass.getInstance();
    }
    public Response patchUserActivity(String userId, Boolean isActive) throws IOException {
        RequestBodyLoader loader = new RequestBodyLoader(BODY_FILE_PATH);
        Map<String, String> replacements = Map.of(
                "isActive", isActive != null ? isActive.toString() : "null"
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
                .patch(testBaseClass.getUserEndpoint() + "/" + userId + "/activity")
                .then()
                .log().all()
                .extract()
                .response();
        response.prettyPrint();

        TestBaseClass.setResponse(response);

        return response;
    }
}
