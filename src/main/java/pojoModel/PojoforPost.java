package pojoModel;

import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"userAddress",
"user_first_name",
"user_last_name",
"user_contact_number",
"user_email_id"
})
@Generated("jsonschema2pojo")
public class PojoforPost {

@JsonProperty("userAddress")
private UserAddress userAddress;
@JsonProperty("user_first_name")
private String userFirstName;
@JsonProperty("user_last_name")
private String userLastName;
@JsonProperty("user_contact_number")
private String userContactNumber;
@JsonProperty("user_email_id")
private String userEmailId;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public PojoforPost() {
}

/**
*
* @param userAddress
* @param userContactNumber
* @param userEmailId
* @param creationTime
* @param userLastName
* @param userFirstName
*/
public PojoforPost(UserAddress userAddress, String userFirstName, String userLastName, String userContactNumber, String userEmailId) {
super();
this.userAddress = userAddress;
this.userFirstName = userFirstName;
this.userLastName = userLastName;
this.userContactNumber = userContactNumber;
this.userEmailId = userEmailId;
}

@JsonProperty("userAddress")
public UserAddress getUserAddress() {
return userAddress;
}

@JsonProperty("userAddress")
public void setUserAddress(UserAddress userAddress) {
this.userAddress = userAddress;
}

@JsonProperty("user_first_name")
public String getUserFirstName() {
return userFirstName;
}

@JsonProperty("user_first_name")
public void setUserFirstName(String userFirstName) {
this.userFirstName = userFirstName;
}

@JsonProperty("user_last_name")
public String getUserLastName() {
return userLastName;
}

@JsonProperty("user_last_name")
public void setUserLastName(String userLastName) {
this.userLastName = userLastName;
}

@JsonProperty("user_contact_number")
public String getUserContactNumber() {
return userContactNumber;
}

@JsonProperty("user_contact_number")
public void setUserContactNumber(String userContactNumber) {
this.userContactNumber = userContactNumber;
}

@JsonProperty("user_email_id")
public String getUserEmailId() {
return userEmailId;
}

@JsonProperty("user_email_id")
public void setUserEmailId(String userEmailId) {
this.userEmailId = userEmailId;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}