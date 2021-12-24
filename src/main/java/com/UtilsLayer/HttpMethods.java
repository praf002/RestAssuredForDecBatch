package com.UtilsLayer;

import org.json.simple.JSONObject;

import com.BaseLayer.BaseClass;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpMethods extends BaseClass {


	private static JSONObject json;
	

	public static Response getRequest(String id) {
		resp = httpRequest.request(Method.GET, id);
		return resp;
	}

	public static void jsonData(String firstName, String lastName, String job, String location) {
		 json = new JSONObject();
		json.put("First Name", firstName);
		json.put("Last Name", lastName);
		json.put("Job", job);
		json.put("Location", location);

		httpRequest.body(json.toString());
	}

	public static Response postRequest() {
		return httpRequest.request(Method.POST);
	}

	public static Response putRequest(String id ) {
		return httpRequest.request(Method.PUT,id);
	}

	public static void updateSpecificData(String key, String value) {
		 json = new JSONObject();

		if (key.equals("Last Name")) 
		{
			json.put(key, value);
		} 
		else if (key.equals("Job")) {
			json.put(key, value);
		} 
		else if (key.equals("Location")) {
			json.put(key, value);
		}

		httpRequest.body(json.toString());
	}

	
	public static Response patchRequest(String id) {
		return httpRequest.request(Method.PATCH,id);
		
	}
	
	public static Response deleteRequest(String id) {
		return httpRequest.request(Method.DELETE,id);
	}
	
	public static int validateStatusCode() {
	
		int actualStatusCode= resp.getStatusCode();
		return actualStatusCode;
	}
	
	public static String validateStatusLine() {
		return resp.getStatusLine();
	}
	
	public static boolean validateResponsePayload(String value) {
		return resp.getBody().asString().contains(value);
	}
	
	public static String validatResponseBody() {
		return resp.getBody().asString();
	}
	
	public static void validateAllHeader() {
		Headers allheader=resp.headers();
		for(Header abc:allheader)
		{
			System.out.println(abc.getName()+" "+abc.getValue());
		}
	}
	
	public static String validateContentTypeHeader() {
		return resp.header("Content-Type");
	}
	
	
	
}
