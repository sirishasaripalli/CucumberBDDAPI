package Helpers;

import java.net.HttpURLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

import Constants.EndPoint;
import Utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoModel.PojoforPost;
import pojoModel.UserAddress;

public class ServiceHelpers {
	private static String BASE_URL = ConfigManager.getInstance().getString("BASE_URL");
    private static  String USERNAME = ConfigManager.getInstance().getString("USERNAME");
	private static  String PASSWORD = ConfigManager.getInstance().getString("PASSWORD");
	private static String end_point;
	
public Response CreateUser(String endPoint) {
	PojoforPost pop = new PojoforPost();
	UserAddress uad = new UserAddress();
	pop.setUserFirstName("sirisha");
	pop.setUserLastName("saripalli");
	pop.setUserContactNumber("4908908908");
	pop.setUserEmailId("telete_donaldll21208@gmail.com");
	uad.setPlotNumber("12-56");
	uad.setStreet("laurel way");
	uad.setState("VA");
	uad.setCountry("usa");
	uad.setZipCode("20171");
	pop.setUserAddress(uad);

	System.out.println(pop);
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.when().auth().basic(USERNAME, PASSWORD)
			.body(pop).baseUri(BASE_URL)
			.post(endPoint);

	String jsonString = response.asString();
	String email = response.jsonPath().get("user_email_id");
	String id =  response.jsonPath().getString("user_id");
	System.out.println(jsonString);
	System.out.println(email + id);
	return response;
	
}

public Response updateUser(String endPoint, String userID) {
	PojoforPost pop = new PojoforPost();
	UserAddress uad = new UserAddress();
	pop.setUserFirstName("sirisha");
	pop.setUserLastName("saripalli");
	pop.setUserContactNumber("4908908927");
	pop.setUserEmailId("change_donaldll21208@gmail.com");
	uad.setPlotNumber("12-ABCD");
	uad.setStreet("laurel change");
	uad.setState("VA");
	uad.setCountry("usa");
	uad.setZipCode("20171");
	pop.setUserAddress(uad);
	endPoint = endPoint + "/" + userID;

	System.out.println(pop);
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.when().auth().basic(USERNAME, PASSWORD)
			.body(pop).baseUri(BASE_URL)
			.put(endPoint);

	String jsonString = response.asString();
	String email = response.jsonPath().get("user_email_id");
	String plot_num =  response.jsonPath().getString("userAddress.plotNumber");
	String street =  response.jsonPath().getString("userAddress.street");
	System.out.println(jsonString);
	System.out.println(email + plot_num + street);
	return response;
	
}
	
}
