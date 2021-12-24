package APITutorial3;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.ExcelReader;
import com.UtilsLayer.HttpMethods;

public class PostDemo extends BaseClass{
	String actualResponseBodyUsingPostMethod;

	@BeforeClass
	public void setUp() {
		BaseClass baseclass=new BaseClass();
		baseclass.intilization();
		httpRequest.header("Content-Type", "application/json");
		ExcelReader excel=new ExcelReader("/Users/prafulpawar/Nov Script /RestAssuredNovBatch/src/main/java/com/testData/TestData.xlsx");
		
		HttpMethods.jsonData(excel.getData(0, 1, 0), excel.getData(0, 1, 1), excel.getData(0, 1, 2), excel.getData(0, 1, 3));
		resp =HttpMethods.postRequest();
	}

	@Test(priority=1)
	public void validateStatusCode() {
		int actualStatusCode =HttpMethods.validateStatusCode();
		Assert.assertEquals(actualStatusCode, 201);
	}
	
	
	
	@Test(priority=2)
	public void validateStatusLine() {
		String actualStatusLine =HttpMethods.validateStatusLine();
		Assert.assertEquals(actualStatusLine, prop.getProperty("statusLineforPost"));
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
	public void validateResposeBody() {
		actualResponseBodyUsingPostMethod=HttpMethods.validatResponseBody();
		System.out.println(actualResponseBodyUsingPostMethod);
	}
	
	@Test(priority=6)
	public void validategetResponseBody() {
		String id=resp.getBody().jsonPath().getString("id");
		resp =HttpMethods.getRequest(id);
		String actualResponseBodyByGetMethod=HttpMethods.validatResponseBody();
		Assert.assertEquals(actualResponseBodyByGetMethod, actualResponseBodyUsingPostMethod);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
