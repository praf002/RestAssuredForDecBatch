package APITestLayer;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDemo4 extends BaseClass {
	RequestSpecification httpRequest;
	Response resp;
	String actualStatusLine;
	String actualBody;
	boolean a;

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = prop.getProperty("url");
		httpRequest = RestAssured.given();
		resp = httpRequest.request(Method.GET, "/3");
	}

	@Test(priority=1)
	public void validateStatusLine() {
		actualStatusLine = resp.getStatusLine();
		Assert.assertEquals(actualStatusLine, "HTTP/1.1 200 OK");
	}

	@Test(priority=2)
	public void validateStatusCode() {
		int actulaStatusCode = resp.getStatusCode();
		Assert.assertEquals(actulaStatusCode, 200);
	}

	@Test(priority=3)
	public void validateStatusCodeInStatusLine() {
		boolean statusCode = actualStatusLine.contains("200");
		Assert.assertEquals(statusCode, true);
	}

	@Test(priority=4)
	public void validateFirstNameInResponseBody() {
		actualBody = resp.getBody().asString();
		boolean actualFirstName = actualBody.contains("Onkar");
		Assert.assertEquals(actualFirstName, true);
	}

	@Test(priority=5)
	public void validateLastNameInResponseBody() {
		boolean actualLastName = actualBody.contains("Kumbhar");
		Assert.assertEquals(actualLastName, true);
	}

	@Test(priority=6)
	public void validateJobInResponseBody() {
		Assert.assertEquals(actualBody.contains("Sr Automation Test Engineer"), true);
	}

	@Test(priority=7)
	public void validateLocationInResponseBody() {
		Assert.assertEquals(actualBody.contains("Pune"), true);
	}

	@Test(priority=8)
	public void validateContentTypeHeader() {
		String actulContentTypeHeader=resp.header("Content-Type");
		
		Assert.assertEquals(actulContentTypeHeader, "application/json; charset=utf-8");
	}
	
	@Test(priority=9)
	public void validateResposeTime() {
		Long actualRespTime=resp.getTime();
		System.out.println(actualRespTime);
			
		if(actualRespTime<=10)
		{
			 a=true;
		}
		else {
			a=false;
			
		}
		
		Assert.assertEquals(a, true);
		
	}

	
}
