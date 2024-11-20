package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class TestBaseClass {

    public static String userId;
    private static Response response;
    public static Response getResponse() {
        return response;
    }
    public static void setResponse(Response response) {
        TestBaseClass.response = response;
    }
    private static final String BASE_URL = "https://7d851fb7-aac2-4995-a48d-0f129b9d6098.mock.pstmn.io";
    private static Map<String, String> headers = new HashMap<>();
    private static TestBaseClass instance;
    public static TestBaseClass getInstance() {
        if (instance == null) {
            instance = new TestBaseClass();
        }
        return instance;
    }
    public TestBaseClass() {
        RestAssured.baseURI = BASE_URL;
        headers.put("Content-Type", "application/json");
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getUserEndpoint() {
        return "/users";
    }
}
