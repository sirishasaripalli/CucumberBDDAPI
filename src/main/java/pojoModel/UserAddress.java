package pojoModel;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"plotNumber",
"street",
"state",
"country",
"zipCode"
})
@Generated("jsonschema2pojo")
public class UserAddress {

@JsonProperty("plotNumber")
private String plotNumber;
@JsonProperty("street")
private String street;
@JsonProperty("state")
private String state;
@JsonProperty("country")
private String country;
@JsonProperty("zipCode")
private String zipCode;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public UserAddress() {
}

/**
*
* @param country
* @param zipCode
* @param street
* @param plotNumber
* @param state
*/
public UserAddress(String plotNumber, String street, String state, String country, String zipCode) {
super();

this.plotNumber = plotNumber;
this.street = street;
this.state = state;
this.country = country;
this.zipCode = zipCode;
}

@JsonProperty("plotNumber")
public String getPlotNumber() {
return plotNumber;
}

@JsonProperty("plotNumber")
public void setPlotNumber(String plotNumber) {
this.plotNumber = plotNumber;
}

@JsonProperty("street")
public String getStreet() {
return street;
}

@JsonProperty("street")
public void setStreet(String street) {
this.street = street;
}

@JsonProperty("state")
public String getState() {
return state;
}

@JsonProperty("state")
public void setState(String state) {
this.state = state;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("zipCode")
public String getZipCode() {
return zipCode;
}

@JsonProperty("zipCode")
public void setZipCode(String zipCode) {
this.zipCode = zipCode;
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