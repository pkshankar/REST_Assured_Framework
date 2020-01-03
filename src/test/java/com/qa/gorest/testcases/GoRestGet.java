package com.qa.gorest.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.client.RestClient;
import com.qa.gorest.responsecode.ResponseCode;
import com.qa.gorest.testbase.TestBase;
import com.qa.gorest.util.Util;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GoRestGet extends TestBase {

	String baseUrl, serviceUrl, uri;
	Response response;

	@BeforeMethod
	public void setUp() {

		baseUrl = prop.getProperty("base_Url");
	}

	@Test
	public void getAllUsersTest() {

		serviceUrl = prop.getProperty("service_Url_Get_All_Users");
		response = RestClient.get(baseUrl,
				Util.addToMap(prop.getProperty("authorization_Key"), prop.getProperty("authorization_Value")),
				serviceUrl);
		// System.out.println(response.getBody().prettyPrint());
		Assert.assertEquals(RestClient.getResponseCode(response), ResponseCode.RESPONSE_CODE_200);
		JsonPath jPath = response.jsonPath();
		//System.out.println(jPath.get("_meta.rateLimit.limit"));
		System.out.println(jPath.getJsonObject("result._links.self"));

	}

}
