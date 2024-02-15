package stepDefinitions;

import org.junit.Assert;

import Constants.EndPoint;
import Helpers.ServiceHelpers;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class PostSteps {
	private ServiceHelpers sh;
	private String endPoint;
	private int actualResponseCode;
	Response response;

	
	@Given("User creates POST Request for Create New User endpoint createusers")
	public void user_creates_post_request_for_create_new_user_endpoint_createusers() {
		endPoint = EndPoint.CREATE_PERSON;
	}

	@When("User sends HTTPS Request and with valid request body")
	public void user_sends_https_request_and_with_valid_request_body() {
		System.out.println("I am tttthereeeee");
		sh = new ServiceHelpers();
		//sh.CreateUser();
		response = sh.CreateUser(endPoint);
		String id =  response.jsonPath().getString("user_id");
		System.out.println("I am hereeeee");
	    System.out.println(id);
	    
	  //Assert.assertNotNull(id, "User Id is not null");  
	}

	@Then("User receives {int} Status with response body")
	public void user_receives_status_with_response_body(Integer int1) {
		   actualResponseCode = response.getStatusCode();
		   Assert.assertEquals(actualResponseCode, 201);
		   System.out.println("Response I got: "+ actualResponseCode);
	}


}
