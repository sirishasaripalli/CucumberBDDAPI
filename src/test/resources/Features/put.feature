Feature: Get All users information from Swagger API(GET REQUEST (Get All Users)
SWAGGER LINK : https://userapi-8877aadaae71.herokuapp.com/swagger-ui.html


  @tag1
  Scenario: Check if user is able to update user details with valid user id
    Given User creates put request with valid update user body
    When  User sends HTTPS request with valid user id
    Then  User receives 200 Status with response body for put request
    