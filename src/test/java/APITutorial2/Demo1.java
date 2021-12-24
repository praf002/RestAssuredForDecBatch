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

public class Demo1 extends BaseClass {
	private Response resp;
	private RequestSpecification httpRequest;
	private ExcelReader excel;

	@BeforeClass
	public void setUp() {

		RestAssured.baseURI = prop.getProperty("url");
		httpRequest = RestAssured.given();

		httpRequest.header("Content-Type", "application/json");
		excel = new ExcelReader(
				"/Users/prafulpawar/Nov Script /RestAssuredNovBatch/src/main/java/com/testData/TestData.xlsx");

		JSONObject json = new JSONObject();

		json.put("First Name", excel.getData(0, 1, 0));
		json.put("Last Name", excel.getData(0, 1, 1));
		json.put("Job", excel.getData(0, 1, 2));
		json.put("Location", excel.getData(0, 1, 3));

		httpRequest.body(json.toString());

		resp = httpRequest.request(Method.PUT, "/5");

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
		boolean actualFirstName = resp.getBody().asString().contains("Amit");
		Assert.assertEquals(actualFirstName, true);

	}

	@Test(priority = 4)
	public void validateFirstName() {
		//String actualFN = resp.getBody().jsonPath().getString("First Name");
		String expectedFNInExcelsheet = excel.getData(0, 1, 0);
		Assert.assertEquals("Amit", expectedFNInExcelsheet);
	}

	@Test(priority = 5)
	public void validateHeader() {
		Headers allHeader = resp.headers();

		for (Header abc : allHeader) {
			System.out.println(abc.getName() + " " + abc.getValue());
		}

	}

}
