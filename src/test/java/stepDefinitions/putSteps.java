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


public class putSteps {
	private ServiceHelpers sh;
	private String endPoint;
	private int actualResponseCode;
	Response response;
	//private String userId = "7861";
@Given("User creates put request with valid update user body")
public void user_creates_put_request_with_valid_update_user_body() {
	endPoint = EndPoint.UPDATE_PERSON;
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
}

@When("User sends HTTPS request with valid user id")
public void user_sends_https_request_with_valid_user_id() {
	sh = new ServiceHelpers();
	//sh.CreateUser();
	response = sh.updateUser(endPoint, "7861");
	String id =  response.jsonPath().getString("user_id");
	System.out.println("The response is: " +response.prettyPrint());
    System.out.println(id);
}

@Then("User receives {int} Status with response body for put request")
public void user_receives_status_with_response_body_for_put_request(Integer int1) {
	   actualResponseCode = response.getStatusCode();
	   Assert.assertEquals(actualResponseCode, 200);
	   System.out.println("Response I got: "+ actualResponseCode);
}
}