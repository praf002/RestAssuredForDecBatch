package APITutorial3;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.HttpMethods;

public class GetDemo extends BaseClass {

	@BeforeClass
	public void setUp() {
		BaseClass baseclass = new BaseClass();
		baseclass.intilization();
		resp = HttpMethods.getRequest("5");
	}

	@Test(priority=1)
	public void validateResponseBody() {
		String a = HttpMethods.validatResponseBody();
		System.out.println(a);
	}

	@Test(priority=2)
	public void validateSpecificEntityInResponseBody() {
		boolean a =HttpMethods.validateResponsePayload("Suraj");
		Assert.assertEquals(a, true);
	}
	
	
	
	
}
