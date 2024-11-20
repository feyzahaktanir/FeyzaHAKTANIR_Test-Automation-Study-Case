# Update User

## Scenario: Update user infos
* Create a user for userId with details:
        | firstName | lastName | username    | password   |
        | John      | Doe      | johndoe123  | pass1234   |
* Send a PUT request to update the user with details:
        | firstName | lastName |
        | John      | Doe      |
* Verify the response status code should be 200
* Verify the response should contain the userId