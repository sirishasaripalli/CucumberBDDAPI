Feature: Get All users information from Swagger API(GET REQUEST (Get All Users)
SWAGGER LINK : https://userapi-8877aadaae71.herokuapp.com/swagger-ui.html


  @tag1
  Scenario: Check if the user is able to create a new user with valid request body in JSON raw data
    Given User creates POST Request for Create New User endpoint createusers
    When  User sends HTTPS Request and with valid request body
    Then  User receives 201 Status with response body
    