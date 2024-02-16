package Helpers;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import org.apache.http.util.Asserts;

import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;
import com.fasterxml.jackson.databind.ObjectMapper;

import Constants.EndPoint;
import Utils.ConfigManager;
//import groovyjarjarantlr.collections.List;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoModel.PojoforPost;
import pojoModel.UserAddress;


public class E2EHelpers {
	private static String BASE_URL = ConfigManager.getInstance().getString("BASE_URL");
    private static  String USERNAME = ConfigManager.getInstance().getString("USERNAME");
	private static  String PASSWORD = ConfigManager.getInstance().getString("PASSWORD");
	private static String end_point;
	PojoforPost pop = new PojoforPost();
	UserAddress uad = new UserAddress();
	
public 	E2EHelpers() {
	RestAssured.baseURI = BASE_URL;
}

public Response getAllUsers(String endPoint){
	System.out.println("Calling GetAllUsers API: " + BASE_URL + endPoint);
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.when().auth().basic(USERNAME, PASSWORD).baseUri(BASE_URL)
			.get(endPoint);
   return response;

}

public Response getUser(String endPoint, String userID){
	System.out.println("Calling GetUser API: " + BASE_URL + endPoint + "/" + userID);
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.when().auth().basic(USERNAME, PASSWORD).baseUri(BASE_URL).pathParam("user_id", userID)
			.get(endPoint + "/{user_id}");
   return response;

}

public Response CreateUser(String endPoint) {
	pop.setUserFirstName("sirisha");
	pop.setUserLastName("saripalli");
	pop.setUserContactNumber("9090908084");
	pop.setUserEmailId("sirisha9094@gmail.com");
	uad.setPlotNumber("123-ABC");
	uad.setStreet("laurel way");
	uad.setState("VA");
	uad.setCountry("usa");
	uad.setZipCode("20171");
	pop.setUserAddress(uad);

	System.out.println(pop);
	System.out.println("Calling CreateUser API: " + BASE_URL + endPoint);
	
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
	pop.setUserFirstName("sirishaC");
	pop.setUserLastName("saripalliC");
	pop.setUserContactNumber("9090908085");
	pop.setUserEmailId("sirisha9095@gmail.com");
	uad.setPlotNumber("123-ABCC");
	uad.setStreet("laurel wayC");
	uad.setState("VAC");
	uad.setCountry("usaC");
	uad.setZipCode("201715");
	pop.setUserAddress(uad);
	//endPoint = endPoint + "/" + userID;
	System.out.println(pop);
	System.out.println("Calling UpdateUser API: " + BASE_URL + endPoint + "/" + userID);
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.when().auth().basic(USERNAME, PASSWORD)
			.body(pop).baseUri(BASE_URL).pathParam("user_id", userID)
			.put(endPoint + "/{user_id}");
			//.put(endPoint + "/userID");
	//("/item/{itemNumber}/buy/{amount}").
	String jsonString = response.asString();
	String email = response.jsonPath().get("user_email_id");
	String plot_num =  response.jsonPath().getString("userAddress.plotNumber");
	String street =  response.jsonPath().getString("userAddress.street");
	System.out.println(jsonString);
	System.out.println(email + plot_num + street);
	return response;
	
}

public Response deleteUser(String endPoint, String userID) {
	
	System.out.println("Calling DeleteUserId API: " + BASE_URL + endPoint + "/" + userID);
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.when().auth().basic(USERNAME, PASSWORD).baseUri(BASE_URL).pathParam("user_id", userID)
			.delete(endPoint + "/{user_id}");
   return response;
	
}
public Response deleteUserName(String endPoint, String username) {
	
	System.out.println(BASE_URL+endPoint);
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.when().auth().basic(USERNAME, PASSWORD).baseUri(BASE_URL).pathParam("user_first_name", username)
			.delete(endPoint+ "/{username}");
   return response;
	
}	
public Response deleteUserNameGetCall(String endPoint, String username) {
	

	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.when().auth().basic(USERNAME, PASSWORD).baseUri(BASE_URL)
			.get(endPoint);
   return response;
	
}	
}
