package stepDefinitions;

import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import org.testng.Assert;
import requests.GET_Users;
import requests.POST_CreateUser;
import utilities.TestBaseClass;

import java.io.IOException;
import java.util.Map;

import static utilities.TestBaseClass.userId;

public class UserListsSteps {

    public static class UserListSteps {
        Response response = TestBaseClass.getResponse();

        @Step("Send a GET request for all users")
        public void sendGetRequestForAllUsers() throws IOException {
            GET_Users getUsersRequest = new GET_Users();
            response = getUsersRequest.getUsers();
        }

        @Step("Verify the response should contain a list of users")
        public void verifyResponseContainsListOfUsers() {
            Assert.assertFalse(response.jsonPath().getList("data").isEmpty(), "The response should contain a list of users");
        }

        @Step("Create a user for userId with details:")
        public void createUserForUserId(Map<String, String> userDetails) throws IOException {
            POST_CreateUser createUserRequest = new POST_CreateUser();
            String firstName = userDetails.get("firstName");
            String lastName = userDetails.get("lastName");
            String username = userDetails.get("username");
            String password = userDetails.get("password");
            Response createUserResponse = createUserRequest.postCreateUser(firstName, lastName, username, password);
            Assert.assertEquals(String.valueOf(response.getStatusCode()), "200", "Status code mismatch!");
            userId = createUserResponse.jsonPath().getString("userId");
            Assert.assertNotNull(userId, "UserId is null");
        }

        @Step("Send a GET request for the user by ID")
        public void sendGetRequestForUserById() throws IOException {
            GET_Users getUserRequest = new GET_Users();
            response = getUserRequest.getUsersById(userId);
        }

        @Step("Verify the response match user infos")
        public void verifyResponseMatchUserInfos(Map<String, String> userDetails) {
            Assert.assertEquals(response.jsonPath().getString("firstName"), userDetails.get("firstName"));
            Assert.assertEquals(response.jsonPath().getString("lastName"), userDetails.get("lastName"));
            Assert.assertEquals(response.jsonPath().getString("username"), userDetails.get("username"));
            Assert.assertEquals(response.jsonPath().getString("userId"), userId);
        }
    }

}
