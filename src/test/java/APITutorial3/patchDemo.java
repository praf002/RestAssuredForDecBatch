package APITutorial3;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.HttpMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class patchDemo extends BaseClass{
	
	@BeforeClass
	public void setUp() {
		BaseClass base=new BaseClass();
		base.intilization();
		httpRequest.header("Content-Type", "application/json");
		HttpMethods.updateSpecificData("Last Name", "Pandit");
		resp =HttpMethods.patchRequest("2");
	}
	
	@Test(priority=1)
	public void validateStatusCode() {
		
		int actualStatusCode=HttpMethods.validateStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
	}
	
	@Test(priority=2)
	public void validateStatusLine() {
		String actualStutusLine =HttpMethods.validateStatusLine();
		Assert.assertEquals(actualStutusLine, prop.getProperty("statusLine"));
	}
	
	@Test(priority=3)
	public void validateresponseBody() {
		String a=HttpMethods.validatResponseBody();
		System.out.println(a);
	}
	
	@Test(priority=4)
	public void validateContentHeader() {
		String actualcontentTypeHeader=HttpMethods.validateContentTypeHeader();
		Assert.assertEquals(actualcontentTypeHeader, prop.getProperty("contentHeader"));
	
	}
	
	
	
}
