# User Lists

## Scenario: Get all users
* Send a GET request for all users
* Verify the response status code should be 200
* Verify the response should contain a list of users

## Scenario: Get user by ID
* Create a user for userId with details:
        | firstName | lastName | username    | password   |
        | John      | Doe      | johndoe123  | pass1234   |
* Send a GET request for the user by ID
* Verify the response status code should be 200
* Verify the response match user infos
