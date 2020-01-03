package com.qa.gorest.testcases;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.client.RestClient;
import com.qa.gorest.pojo.CreateUser;
import com.qa.gorest.testbase.TestBase;
import com.qa.gorest.util.Util;

import io.restassured.response.Response;

public class GoRestPost extends TestBase {

	String baseUrl, serviceUrl, uri;
	Response response;

	@BeforeMethod
	public void setUp() {

		baseUrl = prop.getProperty("base_Url");
	}

	@Test
	public void createUserTest() {

		serviceUrl = prop.getProperty("service_Url_Post_User");
		CreateUser createUser = new CreateUser();
		createUser.setFirst_name("Sam");
		createUser.setLast_name("Pevoz");
		createUser.setGender("male");
		createUser.setEmail("sampevoz@email.com");
		createUser.setStatus("active");
		// Util.addToMap(prop.getProperty("authorization_Key"),
		// prop.getProperty("authorization_Value"));
		// Util.addToMap("Content-Type", "application/json");
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put(prop.getProperty("authorization_Key"), prop.getProperty("authorization_Value"));
		hMap.put("Content-Type", "application/json");
		response = RestClient.post(baseUrl, hMap, serviceUrl, createUser);
		response.prettyPrint();
	}

}
