package stepDefinitions;

import org.apache.http.HttpStatus;
import org.junit.Assert;

import com.fasterxml.jackson.core.type.TypeReference;

import Constants.EndPoint;
import Helpers.ServiceHelpers;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojoModel.PojoforPost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Type;

public class GETSteps {
	
	//private Scenario scenario;
    private ServiceHelpers sh;
	private String endPoint;
	private int actualResponseCode;
	Response response;
	
	@Given("User Creates GET Request for Retrieving all users with endpoint")
	public void user_creates_get_request_for_retrieving_all_users_with_endpoint() {
		endPoint = EndPoint.GET_PERSON_ALL;
  	}

	@When("User Sends HTTPS Request and Basic Auth token")
	public void user_sends_https_request_and_basic_auth_token() {
		System.out.println("I am tttthereeeee");
		sh = new ServiceHelpers();
		//sh.CreateUser();
		response = sh.getAllUsers(endPoint);
		
	   Type type = new TypeReference<List<PojoforPost>>(){}.getType();
	   List<PojoforPost> usersList = response.as(type);
	   String jsonString = response.prettyPrint();
	   System.out.println("The json string is: " + jsonString);
	   System.out.println(usersList); 
	}

	@Then("User receives Status code as 200 ok with response body")
	public void user_receives_status_code_as_ok_with_response_body() {
	   actualResponseCode = response.then().extract().statusCode();
	   Assert.assertEquals(actualResponseCode, 200);
	   System.out.println("Response I got: "+ actualResponseCode);
	  	 
	}

}
