package com.test;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RandomTest {
	
	@Test
	public void test1() {
		
		String res = RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://reqres.in")
		.basePath("/api/users")
		.header("Conten-Type", "application/json")
		.body("{\r\n"
				+ "    \"name\": \"morpheus12\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.when()
			.post()
		.then()
			.log()
			.all()
			.statusCode(201)
			.body("createdAt", Matchers.matchesRegex("[a-zA-Z0-9\\:\\-\\.]*"))
			.extract().asPrettyString();
		
		JsonPath js = new JsonPath(res);
		String id = js.getString("id");
		System.out.println(id);
	}
	
public void test2() {
		
		Response res = RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://reqres.in")
		.basePath("/api/users")
		.header("Conten-Type", "application/json")
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.when()
			.post();
		
		JsonPath js = new JsonPath(res.toString());
		String id = js.getString("id");
		System.out.println(id);
		MatcherAssert.assertThat(res.toString(), JsonSchemaValidator.matchesJsonSchemaInClasspath(""));
	}

}
