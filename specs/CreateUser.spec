# CreateUser.spec
  tags: success
## Scenario: Successfully create a new user
* Send a POST request to create the user with details: <table>
    | firstName | lastName | username    | password   |
    |-----------|----------|-------------|------------|
    | John      | Doe      | johndoe123  | pass1234   |
* Verify the response status code should be 200
* Verify the response should contain the userId
