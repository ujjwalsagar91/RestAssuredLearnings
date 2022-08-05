package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestJsonPath {
	
	@Test
	public void getpath() {
		
		Response res = RestAssured.given().log().all().baseUri("https://run.mocky.io/v3/b03846d7-b934-4720-8750-8ab37cdaed30").get();
		
//		Response res = RestAssured.given().log().all().baseUri("https://run.mocky.io/v3/df365396-567d-49a5-91a4-ca8914a13840").get();
		
		JsonPath js = new JsonPath(res.asPrettyString());
		
		System.out.println(res.asPrettyString());
		
		System.out.println(js.getString("[0].address.city"));
		
//		System.out.println("First name of first female employee : "+js.getString("find{it.gender == 'Female'}.first_name"));
		
		System.out.println("Last name of employee : "+js.getString("find{it.firstName == 'John'}.lastName"));

		
	}

}
