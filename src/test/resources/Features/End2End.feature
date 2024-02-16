Feature: Get All users information from Swagger API(GET REQUEST (Get All Users)
SWAGGER LINK : https://userapi-8877aadaae71.herokuapp.com/swagger-ui.html
          

@tag1
Scenario: POST
Given User Creates POST Request for creating a new user with endpoint
When User Sends POST HTTPS Request and Basic Auth token
Then User receives Status code as POST ok with response body
When User Sends GET HTTPS Request and Basic Auth token
Then User receives Status code as GET ok with response body
When User sends PUT request with valid update details in the Request  body
Then User receives Status code for PUT ok with response body
When User sends a DELETE call with Valid User Id
Then User receives Status code for DELETE ok with response body
