# Users Activity

## Active User
* Create a user for userId with details:
    | firstName | lastName | username    | password   |
    | John      | Doe      | johndoe123  | pass1234   |
* PATCH request to update the user's activity to true
* Verify the response status code is 200
* Verify the user's activity is set to true


## Passive User
* Create a user for userId with details:
    | firstName | lastName | username    | password   |
    | John      | Doe      | johndoe123  | pass1234   |
* Send a PATCH request to update the user's activity to false
* Verify the response status code is 200
* Verify the user's activity is set to false


