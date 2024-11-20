package stepDefinitions;

import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import requests.PUT_UpdateUsers;
import utilities.TestBaseClass;

import java.io.IOException;
import java.util.Map;
import static utilities.TestBaseClass.userId;


public class UpdateUserSteps {

    @Step("Send a PUT request to update the user with details:")
    public void updateUserForUserId( Map<String, String> userDetails) throws IOException {
        String firstName = userDetails.get("firstName");
        String lastName = userDetails.get("lastName");
        PUT_UpdateUsers updateUserRequest = new PUT_UpdateUsers();
        Response response = updateUserRequest.putUpdateUser(firstName, lastName, userId);
        TestBaseClass.setResponse(response);
    }
}
