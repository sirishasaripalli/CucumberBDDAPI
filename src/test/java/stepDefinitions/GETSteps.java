package stepDefinitions;

import java.net.URI;
import java.net.URISyntaxException;

import groovyjarjarantlr.collections.List;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import  io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GETSteps {
	
	private Scenario scenario;
    private static  String USERNAME = "*****";
	private static  String PASSWORD = "*****";
	private static  String BASE_URL = "https://userapi-8877aadaae71.herokuapp.com/uap";
	private static  String end_Point;
	private static  String api_call_url;

	
	private static Response response;
	private static String jsonString;
	
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}
	
	
	@Given("User Creates GET Request for Retrieving all users with endpoint")
	public void user_creates_get_request_for_retrieving_all_users_with_endpoint() throws URISyntaxException {
	   	

		end_Point = "/users";
		api_call_url = BASE_URL + end_Point;
		System.out.println("API to Call:" + api_call_url);
  
	}

	@When("User Sends HTTPS Request and Basic Auth token")
	public void user_sends_https_request_and_basic_auth_token() throws URISyntaxException {
		//request.header("Content-Type", "application/json");
		
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		response = request.auth().basic(USERNAME, PASSWORD).get(api_call_url);

		
		String jsonString = response.asString();
		
		System.out.println(jsonString);
		
				
		 
	}

	@Then("User receives Status code as 200 ok with response body")
	public void user_receives_status_code_as_ok_with_response_body() {
	   int actualResponseCode = response.then().extract().statusCode();
	   Assert.assertEquals(actualResponseCode, 200);
	   System.out.println("Response I got: "+ actualResponseCode);
	  	 
	}

}
