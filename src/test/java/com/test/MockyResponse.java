package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class MockyResponse {
	
	@Test
	public void test() {
		
		String res = RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://run.mocky.io/v3/c3655cab-8048-43b9-ba73-9d0342675d5e")
		.when()
			.post()
		.then()
			.log()
			.all()
			.statusCode(201)
			.extract().asPrettyString();
		
		JsonPath js = new JsonPath(res);
		String id = js.getString("id");
		System.out.println(id);
	}

}
