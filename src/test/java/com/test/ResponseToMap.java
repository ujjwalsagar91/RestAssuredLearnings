package com.test;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ResponseToMap {
	
	@Test
	public void test() {
		
		Map<String, Object> map = RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://run.mocky.io/v3/c3655cab-8048-43b9-ba73-9d0342675d5e")
		.when()
			.get()
			.as(new TypeRef<Map<String, Object>>(){});
		
		
		Object id = map.get("id");
		System.out.println(id);
		
	}

}
