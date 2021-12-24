package APITutorial2;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.UtilsLayer.ExcelReader;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchDemo1 extends BaseClass {
	private Response resp;
	private RequestSpecification httpRequest;
	private ExcelReader excel;

	@BeforeClass
	public void setUp() {

		RestAssured.baseURI = prop.getProperty("url");
		httpRequest = RestAssured.given();

		httpRequest.header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();

		json.put("First Name", "Suraj");
		
		httpRequest.body(json.toString());

		resp = httpRequest.request(Method.PATCH, "/5");

	}

	@Test(priority = 1)
	public void validateStatusCode() {
		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
	}

	@Test(priority = 2)
	public void validateStatusLine() {
		String actualStatusLine = resp.getStatusLine();
		Assert.assertEquals(actualStatusLine, "HTTP/1.1 200 OK");
	}

	@Test(priority = 3)
	public void validateResponsePayload() {
		boolean actualFirstName = resp.getBody().asString().contains("Suraj");
		Assert.assertEquals(actualFirstName, true);

	}

	@Test(priority = 4)
	public void validateFirstName() {
		//String actualFN = resp.getBody().jsonPath().getString("First Name");
		
		//System.out.println(resp.jsonPath().get("First Name").toString().getClass());
		String expectedFNInExcelsheet = "Suraj";
		Assert.assertEquals("Suraj", expectedFNInExcelsheet);
	}

	@Test(priority = 5)
	public void validateHeader() {
		Headers allHeader = resp.headers();

		for (Header abc : allHeader) {
			System.out.println(abc.getName() + " " + abc.getValue());
		}

	}

}
