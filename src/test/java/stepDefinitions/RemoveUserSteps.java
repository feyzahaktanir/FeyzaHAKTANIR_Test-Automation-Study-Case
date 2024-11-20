package stepDefinitions;

import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import org.testng.Assert;
import requests.DELETE_Users;
import utilities.TestBaseClass;

import java.io.IOException;

public class RemoveUserSteps {

    Response response = TestBaseClass.getResponse();

    @Step("Send a DELETE request to delete the user by ID")
    public void deleteUserById() throws IOException {
        Assert.assertNotNull(TestBaseClass.userId, "UserId is null, cannot delete the user");
        DELETE_Users deleteUserRequest = new DELETE_Users();
        this.response = deleteUserRequest.deleteUsersById(TestBaseClass.userId);
    }


}
