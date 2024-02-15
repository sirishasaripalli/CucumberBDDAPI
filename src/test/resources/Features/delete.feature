Feature: Get All users information from Swagger API(GET REQUEST (Get All Users)
SWAGGER LINK : https://userapi-8877aadaae71.herokuapp.com/swagger-ui.html


  @tag1
  Scenario: Check if user is able to delete an existing user with user ID
    Given User creates a DELETE request endpoint '<serviceUrlWithEndPoint>'
    When User makes a DELETE call with Valid User Id '<userId>'
    Then User receives a '<code>' OK status with message User is deleted successfully
    Examples: 
    | serviceUrlWithEndPoint                              | userId | code |
    | https://userapi-8877aadaae71.herokuapp.com/uap/deleteuser | 7458   |  200 |

  @tag2
  Scenario Outline: Check if user is able to delete an existing user with username
    Given User creates a DELETE request with username endpoint '<serviceUrlWithEndPoint>'
    When User makes a DELETE call with Valid Username '<userName>'
    Then User receives a '<code>' OK status with message User is deleted successfully
    Examples: 
    | serviceUrlWithEndPoint                              | userName | code |
    | https://userapi-8877aadaae71.herokuapp.com/uap/deleteuser/username | ForDelete   |  200 |
    
    @tag3
  Scenario Outline: Check if user can perform Non-Delete call by Username for Delete Endpoint
    Given User creates a DELETE request with username endpoint '<serviceUrlWithEndPoint>'
    When User makes a GET/POST/PUT  call with Valid Username '<userName>'
    Then User gets a 405 Method Not Allowed status with error message Method Not Allowed is received
    Examples: 
    | serviceUrlWithEndPoint                              | userName | code |
    | https://userapi-8877aadaae71.herokuapp.com/uap/deleteuser/username | ForDelete   |  405 |

    
