package com.test;

import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class ObjectMapperTest {
	
	@Test
	public void testJSONToObject() throws JsonMappingException, JsonProcessingException {
		
		String res = RestAssured
		.given()
		.when()
			.get("https://reqres.in/api/users/2")
			.then()
			.extract().asPrettyString();
			
//		String responseString = res.toString();
		
		System.out.println(res);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> actualData = objectMapper.readValue(res, new TypeReference<Map<String, Object>>(){});
		System.out.println(actualData.get("data"));
		Map<String, Object> innerData = (Map<String, Object>) actualData.get("data");
		System.out.println(innerData.get("id"));
		
		
	}
	
	@Test
	public static void testObjectToJSON() throws JsonProcessingException {
		
		EmployeePOJO emp = new EmployeePOJO();
		emp.setId("24");
		emp.setCreatedAt("Wed 06th July 2022");
		emp.setName("Ujjwal");
		
		ObjectMapper objMap = new ObjectMapper();
		String s = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		System.out.println(s);
		
		RestAssured.given().body(s).log().all().get();
		
		objMap.readValue(s, new TypeReference<Map<String, String>>(){});
		
		objMap.readValue(s, EmployeePOJO.class);
		
	}

}
