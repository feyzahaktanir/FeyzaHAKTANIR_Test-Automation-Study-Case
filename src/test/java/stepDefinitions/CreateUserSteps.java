package stepDefinitions;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.testng.Assert;
import requests.POST_CreateUser;
import io.restassured.response.Response;
import utilities.TestBaseClass;
import static utilities.TestBaseClass.userId;


import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class CreateUserSteps {

    Response response = TestBaseClass.getResponse();

    @Step("Send a POST request to create the user with details: <table>")
    public void sendPostRequestToCreateUser(Table table) throws IOException {
        TableRow firstRow = table.getTableRows().get(0);

        Map<String, String> userDetails = firstRow.getCellValues()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue()
                ));
        POST_CreateUser createUserRequest = new POST_CreateUser();
        response = createUserRequest.postCreateUser(
                userDetails.get("firstName"),
                userDetails.get("lastName"),
                userDetails.get("username"),
                userDetails.get("password")
        );
    }

    @Step("Verify the response status code should be 200")
    public void verifyStatusCode() {
        Assert.assertEquals(String.valueOf(response.getStatusCode()), "200", "Status code mismatch!");
    }

    @Step("Verify the response should contain the userId")
    public void verifyResponseContainsUserId() {
        userId = response.jsonPath().getString("userId");
        Assert.assertNotNull(userId, "userId is missing in the response!");
        System.out.println("Generated userId: " + userId);
    }
}
