package com.test;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class findAllTest {
	
	@Test
	public void findIds() {
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\People.json";
		
		File json = new File(filePath);
		
		JsonPath js = new JsonPath(json);
		
		System.out.println(js.getList("findAll{it.id==9}.first_name"));
		System.out.println(js.getList("first_name"));
	}
	
	

}
