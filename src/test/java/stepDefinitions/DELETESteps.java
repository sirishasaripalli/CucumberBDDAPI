package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DELETESteps {
	
	private Scenario scenario;
    private static  String USERNAME = "Numpy@gmail.com";
	private static  String PASSWORD = "tim123";
	private static  String BASE_URL = "https://userapi-8877aadaae71.herokuapp.com/uap";
	private static  String end_Point;
	private static  String api_call_url;
	
	private static Response response;
	private static String jsonString;
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}
	
	
	@Given("User creates a DELETE request endpoint {string}")
	public void user_creates_a_delete_request_endpoint(String BASE_URL) {
		api_call_url = BASE_URL;
		System.out.println("API to Call:" + api_call_url);
	}

	@When("User makes a DELETE call with Valid User Id {string}")
	public void user_makes_a_delete_call_with_valid_user_id(String end_Point) {
		//RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		api_call_url = api_call_url + "/" + end_Point;
		response = request.auth().basic(USERNAME, PASSWORD).delete(api_call_url);
				
		String jsonString = response.asString();
		
		System.out.println(jsonString);
	}

	@Then("User receives a {string} OK status with message User is deleted successfully")
	public void user_receives_a_ok_status_with_message_user_is_deleted_successfully(String successCode) {
		   int actualResponseCode = response.then().extract().statusCode();
		   Assert.assertEquals(actualResponseCode, successCode);
		   System.out.println("Response I got: "+ actualResponseCode);
	    }

	@Given("User creates a DELETE request with username endpoint {string}")
	public void user_creates_a_delete_request_with_username_endpoint(String BASE_URL) {
	    // Write code here that turns the phrase above into concrete actions
		api_call_url = BASE_URL;
		System.out.println("API to Call:" + api_call_url);
	}

	@When("User makes a DELETE call with Valid Username {string}")
	public void user_makes_a_delete_call_with_valid_username(String end_Point) {
	    // Write code here that turns the phrase above into concrete actions
		RequestSpecification request = RestAssured.given();
		api_call_url = api_call_url + "/" + end_Point;
		response = request.auth().basic(USERNAME, PASSWORD).delete(api_call_url);
		String jsonString = response.asString();
		System.out.println(jsonString);
	}
	@When("User makes a GET\\/POST\\/PUT  call with Valid Username {string}")
	public void user_makes_a_get_post_put_call_with_valid_username(String string) {
		RequestSpecification request = RestAssured.given();
		api_call_url = api_call_url + "/" + end_Point;
		response = request.auth().basic(USERNAME, PASSWORD).put(api_call_url);
		String jsonString = response.asString();
		System.out.println(jsonString);
		
	}

	@Then("User gets a {int} Method Not Allowed status with error message Method Not Allowed is received")
	public void user_gets_a_method_not_allowed_status_with_error_message_method_not_allowed_is_received(Integer int1) {
		 int actualResponseCode = response.then().extract().statusCode();
		   //Assert.assertEquals(actualResponseCode, int1);
		   Assert.assertEquals(actualResponseCode, 405);
		   System.out.println("Response I got: "+ actualResponseCode);
	}
}
