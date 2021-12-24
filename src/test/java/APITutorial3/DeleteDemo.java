package APITutorial3;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.HttpMethods;

public class DeleteDemo extends BaseClass {

	@BeforeClass
	public void setUp() {
		BaseClass baseclass=new BaseClass();
		baseclass.intilization();
		resp=HttpMethods.deleteRequest("6");
	}
	
	@Test(priority=1)
	public void validateStatusCode() {
		int a =HttpMethods.validateStatusCode();
		Assert.assertEquals(a, 200);
	}
	
	@Test(priority=2)
	public void validateStatusLine() {
		String a =HttpMethods.validateStatusLine();
		Assert.assertEquals(a, prop.getProperty("statusLine"));
	}
	
	@Test(priority=3)
	public void validatecontenttypeHeaders() {
		String b =HttpMethods.validateContentTypeHeader();
		Assert.assertEquals(b, prop.getProperty("contentHeader"));
	}




}

