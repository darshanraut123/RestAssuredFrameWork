package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.runner.Request;

import Pojo.Location;
import Pojo.PlaceInfo;
import Resources.Payload;
import Resources.Utils;

public class StepDefination extends Utils{
	RequestSpecification actReqSpec;
	Response res;

		@Given("add place with payload as {string} name {string} address {string} language")
			public void add_place_payload(String name,String address,String language) throws IOException {
			PlaceInfo pi = Payload.getPayload(name,address,language);
			actReqSpec = given().spec(getReqSpec()).body(pi);
		}



	@When("user calls {string} with post http request")
	public void user_calls_with_post_http_request(String string) {
		res = actReqSpec.post("/maps/api/place/add/json")
				.then().spec(getResSpec()).extract().response();
	}

	@Then("the api call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(int expCode) {
		Assert.assertEquals(res.getStatusCode(),expCode);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {		
		String resp = res.asString();
		JsonPath js = new JsonPath(resp);
		String actualValue= js.getString(key);
		Assert.assertEquals(actualValue,expectedValue);
	}



}
