package com.qa.gorest.client;

import java.util.HashMap;
import java.util.Map;

import com.qa.gorest.testbase.TestBase;
import com.qa.gorest.util.Util;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient extends TestBase {

	public static Response get(String baseUri, HashMap<String, String> requestHeaders, String serviceUrl) {

		createBaseUri(baseUri);
		RequestSpecification request = createRequest();
		return addRequestHeaders(request, requestHeaders).get(serviceUrl);
	}

	public static Response post(String baseUri, HashMap<String, String> requestHeaders, String serviceUrl, Object obj) {

		createBaseUri(baseUri);
		RequestSpecification request = createRequest();
		return addRequestPayload(addRequestHeaders(request, requestHeaders), obj).post(serviceUrl);

	}

	public static void put() {

	}

	public static void patch() {

	}

	public static void delete() {

	}

	public static void createBaseUri(String baseUri) {

		RestAssured.baseURI = baseUri;

	}

	public static RequestSpecification createRequest() {

		return RestAssured.given();
	}

	public static RequestSpecification addRequestHeaders(RequestSpecification httpRequest,
			HashMap<String, String> requestHeaders) {

		for (Map.Entry<String, String> headerMap : requestHeaders.entrySet()) {

			httpRequest.header(headerMap.getKey(), headerMap.getValue());
		}

		return httpRequest;

	}

	public static RequestSpecification addRequestPayload(RequestSpecification httpRequest, Object obj) {

		return httpRequest.body(Util.pojoToJson(obj));

	}

	public static int getResponseCode(Response response) {

		return response.getStatusCode();

	}

	public static Headers getResponseHeaders(Response response) {

		return response.headers();
	}

}
