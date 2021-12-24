package com.BaseLayer;

import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	public static Properties prop;
	public static FileInputStream fis;
	public static RequestSpecification httpRequest;
	public static Response resp;

	public BaseClass() {
		prop = new Properties();

		try {
			fis = new FileInputStream(
					"//Users//prafulpawar//Nov Script //RestAssuredNovBatch//src//main//java//com//Config//config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void intilization() {
		RestAssured.baseURI = prop.getProperty("url");
		httpRequest = RestAssured.given();
	}

}
