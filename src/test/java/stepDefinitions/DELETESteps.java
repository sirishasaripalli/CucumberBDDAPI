package stepDefinitions;

import Constants.EndPoint;
import Helpers.ServiceHelpers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class DELETESteps {
	
	
   	private static Response response;
    private ServiceHelpers sh;
	private String endPoint;
	private int actualResponseCode;
	//private String userId = "8167";		

	
	@Given("User creates a DELETE request endpoint {string}")
	public void user_creates_a_delete_request_endpoint(String BASE_URL) {
		endPoint = EndPoint.DELETE_PERSON_ID;
	}

	@When("User makes a DELETE call with Valid User Id {string}")
	public void user_makes_a_delete_call_with_valid_user_id(String userId) {
		sh = new ServiceHelpers();
		System.out.println("My ID from gerkin"+userId);
		response = sh.deleteUser(endPoint, userId);
	}

	@Then("User receives a {string} OK status with message User is deleted successfully")
	public void user_receives_a_ok_status_with_message_user_is_deleted_successfully(String successCode) {
		 actualResponseCode = response.then().extract().statusCode();
		   Assert.assertEquals(actualResponseCode, 200);
		   System.out.println("Response I got: "+ actualResponseCode);
	    }

	@Given("User creates a DELETE request with username endpoint {string}")
	public void user_creates_a_delete_request_with_username_endpoint(String userName) {
	  		endPoint = EndPoint.DELETE_PERSON_NAME;
	}

	@When("User makes a DELETE call with Valid Username {string}")
	public void user_makes_a_delete_call_with_valid_username(String userName) {
		sh = new ServiceHelpers();
		System.out.println("My ID from gerkin"+userName);
		response = sh.deleteUser(endPoint, userName);
		
			}
	@When("User makes a GET\\/POST\\/PUT  call with Valid Username {string}")
	public void user_makes_a_get_post_put_call_with_valid_username(String string) {
		sh = new ServiceHelpers();
		response = sh.deleteUserNameGetCall(endPoint, "username");
		
	}

	@Then("User gets a {int} Method Not Allowed status with error message Method Not Allowed is received")
	public void user_gets_a_method_not_allowed_status_with_error_message_method_not_allowed_is_received(Integer int1) {
		 int actualResponseCode = response.then().extract().statusCode();
		   //Assert.assertEquals(actualResponseCode, int1);
		   Assert.assertEquals(actualResponseCode, 405);
		   System.out.println("Response I got: "+ actualResponseCode);
		   response.then().assertThat().statusCode(405);
	}
}
