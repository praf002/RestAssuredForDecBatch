package APITutorial3;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.HttpMethods;

import io.restassured.response.Response;

public class PatchDemo2 extends BaseClass {

	
	@BeforeClass
	public void setUp() {
		BaseClass baseclass=new BaseClass();
		baseclass.intilization();
		httpRequest.header("Content-Type", "application/json");
		HttpMethods.updateSpecificData("Location", "Delhi");
		resp=HttpMethods.patchRequest("3");
	}
	
	@Test(priority=1)
	public void validateStatusCode() {
		int actualStatusCode =HttpMethods.validateStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
	}
	
	@Test(priority=2)
	public void validateStatusLine() {
		String actualStatusLine =HttpMethods.validateStatusLine();
		Assert.assertEquals(actualStatusLine, prop.getProperty("statusLine"));
	}
	
	
	@Test(priority=3)
	public void validateContentHeader() {
		String actualContentHeader =HttpMethods.validateContentTypeHeader();
		Assert.assertEquals(actualContentHeader, prop.getProperty("contentHeader"));
	}
	
	
	@Test(priority=4)
	public void validateAllHeaders() {
		HttpMethods.validateAllHeader();
	}
	
	
	@Test(priority=5)
	public void validateResponseBody() {
		String a=HttpMethods.validatResponseBody();
		System.out.println(a);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
