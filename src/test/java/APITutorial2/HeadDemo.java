package APITutorial2;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.ExcelReader;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HeadDemo extends BaseClass{

	private Response resp;
	private RequestSpecification httpRequest;
	private ExcelReader excel;

	@BeforeClass
	public void setUp() {

		RestAssured.baseURI = prop.getProperty("url");
		httpRequest = RestAssured.given();
		
		resp =httpRequest.request(Method.HEAD,"/5");
	}
	
	@Test
	public void validateStausLine() {
		String actualStatusLine = resp.getStatusLine();
		Assert.assertEquals(actualStatusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void validateContentTypeHeader() {
		String actualHeader=resp.header("Content-Type");
		Assert.assertEquals(actualHeader, "application/json; charset=utf-8");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
