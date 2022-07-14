package com.test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest {
	
	@Test
	public void getTest() {
		
		Response response = given().get("https://reqres.in/api/users?page=2");
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
		System.out.println(response.headers());
		
	}

}
