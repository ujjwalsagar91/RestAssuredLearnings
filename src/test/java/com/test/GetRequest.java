package com.test;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetRequest {
	
	@Test
	public void getTest() {
		
		Response response = given().get("https://reqres.in/api/users?page=2");
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
		System.out.println(response.headers());
		
		response.then().body("data", Matchers.instanceOf(List.class));
		
		String test = "abc";
		MatcherAssert.assertThat("abc", equals(test));
		
	}

}
