package com.test;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.path.json.JsonPath;

public class ListUsers {
	
	@Test
	public void findIds() throws JsonMappingException, JsonProcessingException {
		
		String res = given().baseUri("https://reqres.in/").basePath("{path1}/{path2}").pathParam("path1", "api").pathParam("path2", "users").queryParam("page", 2).log().all()
		.when().get().then().log().all().extract().asPrettyString();
		
		ObjectMapper objMap = new ObjectMapper();
		Map<String, Object> abc = objMap.readValue(res, new TypeReference<Map<String, Object>>() {});
		System.out.println(abc);
		
		List<Object> abc1 = given().baseUri("https://reqres.in/").basePath("{path1}/{path2}").pathParam("path1", "api").pathParam("path2", "users").queryParam("page", 2).log().all()
		.when().get().jsonPath().getObject("data", List.class);
		
		System.out.println(abc1);
		Map map1 = (Map) abc1.get(0);
		System.out.println(map1.get("id"));
		
		JsonPath js = new JsonPath(res);
		List newList = js.getList("data");
		Map dataMap = (Map) newList.get(0);
		System.out.println(dataMap.get("id"));
		
		System.out.println(js.getString("data.id[1]"));
		
		String abc2 = given().baseUri("https://reqres.in/").basePath("{path1}/{path2}").pathParam("path1", "api").pathParam("path2", "users").queryParam("page", 2).log().all()
				.when().get().jsonPath().getString("data");
		
	}

}
