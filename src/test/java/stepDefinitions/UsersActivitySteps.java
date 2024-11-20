package stepDefinitions;

import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import org.testng.Assert;
import requests.PATCH_Users;

import java.io.IOException;
import static utilities.TestBaseClass.userId;
import utilities.TestBaseClass;


public class UsersActivitySteps {

    Response response = TestBaseClass.getResponse();

    @Step("Send a PATCH request to update the user's activity to true")
    public void patchUserActivity() throws IOException {
        PATCH_Users patchUsersRequest = new PATCH_Users();
        Response response = patchUsersRequest.patchUserActivity(userId, true);
        Assert.assertEquals(200, response.getStatusCode(), "Status code mismatch for PATCH request!");
        TestBaseClass.setResponse(response);
    }

    @Step("Verify the user's activity is set to true")
    public void verifyUserActivity() {
        Response response = TestBaseClass.getResponse();
        Assert.assertTrue(response.jsonPath().getBoolean("isActive"), "User's activity status does not match the expected value!");
    }

    @Step("Verify the user's activity is set to false")
    public void verifyUserActivityfalse() {
        Response response = TestBaseClass.getResponse();
        Assert.assertFalse(response.jsonPath().getBoolean("isActive"), "User's activity status does not match the expected value!");
    }
}
