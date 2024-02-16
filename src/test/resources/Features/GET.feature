Feature: Get All users information from Swagger API(GET REQUEST (Get All Users)
SWAGGER LINK : https://userapi-8877aadaae71.herokuapp.com/swagger-ui.html
          
Scenario: Check it is able to retrive all the Users data from Resource file


Given User Creates GET Request for Retrieving all users with endpoint
When User Sends HTTPS Request and Basic Auth token
Then User receives Status code as 200 ok with response body

