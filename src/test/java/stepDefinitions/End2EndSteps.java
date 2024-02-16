package stepDefinitions;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Assert;

import com.fasterxml.jackson.core.type.TypeReference;

import Constants.EndPoint;
import Helpers.E2EHelpers;
import Helpers.ServiceHelpers;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojoModel.PojoforPost;

public class End2EndSteps {
	private E2EHelpers sh = new E2EHelpers();
	private String endPoint;
	private int actualResponseCode;
	Response response;
	private String userID;
	
	@Given("User Creates POST Request for creating a new user with endpoint")
	public void user_creates_post_request_for_creating_a_new_user_with_endpoint() {
		endPoint = EndPoint.CREATE_PERSON;

	}

	@When("User Sends POST HTTPS Request and Basic Auth token")
	public void user_sends_post_https_request_and_basic_auth_token() {
						
		response = sh.CreateUser(endPoint);
		userID =  response.jsonPath().getString("user_id");
		System.out.println("The response is:" + response.prettyPrint());
	    System.out.println(userID);
	    
	  //Assert.assertNotNull(id, "User Id is not null"); 
	}

	@Then("User receives Status code as POST ok with response body")
	public void user_receives_status_code_as_post_ok_with_response_body() {
		   actualResponseCode = response.getStatusCode();
		   Assert.assertEquals(actualResponseCode, 201);
		   Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
		   System.out.println("Response I got: "+ actualResponseCode);
	}

	@When("User Sends GET HTTPS Request and Basic Auth token")
	public void user_sends_get_https_request_and_basic_auth_token() {
		//sh = new E2EHelpers();
		endPoint = EndPoint.GET_PERSON_ID;
		response = sh.getUser(endPoint, userID );
		
	   //Type type = new TypeReference<List<PojoforPost>>(){}.getType();
	   //List<PojoforPost> usersList = response.as(type);
	   String jsonString = response.prettyPrint();
	   //System.out.println("The json string is: " + jsonString);
	   //System.out.println(usersList);
	}

	@Then("User receives Status code as GET ok with response body")
	public void user_receives_status_code_as_get_ok_with_response_body() {
		actualResponseCode = response.then().extract().statusCode();
		   Assert.assertEquals(actualResponseCode, 200);
		   System.out.println("Response I got: "+ actualResponseCode);
	}


	@When("User sends PUT request with valid update details in the Request  body")
	public void user_sends_put_request_with_valid_update_details_in_the_request_body() {
		endPoint = EndPoint.UPDATE_PERSON;
		response = sh.updateUser(endPoint, userID);
		String id =  response.jsonPath().getString("user_id");
		System.out.println("The response is: " +response.prettyPrint());
	    System.out.println(id);
	}

	@Then("User receives Status code for PUT ok with response body")
	public void user_receives_status_code_for_put_ok_with_response_body() {
		 actualResponseCode = response.getStatusCode();
		 Assert.assertEquals(actualResponseCode, 200);
		 System.out.println("Response I got: "+ actualResponseCode);
	}
	@When("User sends a DELETE call with Valid User Id")
	public void user_sends_a_delete_call_with_valid_user_id() {
		endPoint = EndPoint.DELETE_PERSON_ID;
		response = sh.deleteUser(endPoint, userID);
		String jsonString = response.prettyPrint();
		System.out.println("The json string is: " + jsonString);
	}

	@Then("User receives Status code for DELETE ok with response body")
	public void user_receives_status_code_for_delete_ok_with_response_body() {
		 actualResponseCode = response.then().extract().statusCode();
		 Assert.assertEquals(actualResponseCode, 200);
		 System.out.println("Response I got: "+ actualResponseCode);
	}

}
