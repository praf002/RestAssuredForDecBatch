package APITestLayer;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDemo2 extends BaseClass{
	
	static RequestSpecification httpRequest;
	static Response resp;

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI=prop.getProperty("url");
		 httpRequest=RestAssured.given();
		resp =httpRequest.request(Method.GET,"/2");
	}
	
	@Test(priority=1)
	public static void validateStatusCode() {
		int actualStatusCode=resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
	}
	
	@Test(priority=2)
	public static void validateStatusLine() {
		String actualStatusLine =resp.getStatusLine();
		boolean statusCode=actualStatusLine.contains("200");
		Assert.assertEquals(statusCode, true);
		
	}
	
	
	@Test(priority=3)
	public static void validateResponseBody() {
		String actualRespBody =resp.getBody().asString();
		//System.out.println(actualRespBody);
		boolean actualNamePresentInBody=actualRespBody.contains("Sumit");
		Assert.assertEquals(actualNamePresentInBody, true);
		
	}
	
	@Test(priority=4)
	public static void validateContantTypeHeader() {
		String actualContentType=resp.header("Content-Type");
		Assert.assertEquals(actualContentType, "application/json; charset=utf-8");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
