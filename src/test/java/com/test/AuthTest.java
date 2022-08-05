package com.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AuthTest {
	
	@Test
	public void authTest() {
		
		RestAssured.given().baseUri("").auth().basic(null, null);
		
	}

}
