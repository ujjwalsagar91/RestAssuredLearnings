package com.test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class TestTemp {
	
	@Test
	public void test1() throws JsonMappingException, JsonProcessingException {
		
		baseURI="https://reqres.in";
		basePath="/api/users";
		
		Header header = new Header("Accept", "application/json");
		
		String str = given().header(header).log().all().when().get().andReturn().asPrettyString();
		System.out.println(str);
		
		Response res = given().header(header).log().all().when().get().andReturn();
		
		System.out.println(res.jsonPath().getList("data"));
		
		ObjectMapper map = new ObjectMapper();
		map.readValue(res.asPrettyString(), new TypeReference<List<Map<String, Object>>>() {});
		
		
	}

}
