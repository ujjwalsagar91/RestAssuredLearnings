package com.test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostRequest {
	
	@Test
	public void postRequests1() {
		
		Response response = given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").contentType(ContentType.JSON).log().all().when().post("https://reqres.in/api/users");
		
		System.out.println(response.statusCode());
		response.prettyPrint();
		
	}

}
