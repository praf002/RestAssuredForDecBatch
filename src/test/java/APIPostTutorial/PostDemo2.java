package APIPostTutorial;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDemo2 extends BaseClass {
	Response resp;
	RequestSpecification httpRequest;
	Response resp1;
	String actualPostRespBody ;
	String getBodyByGetMethod;

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = prop.getProperty("url");
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("First Name", prop.getProperty("FirstName"));
		json.put("Last Name", prop.getProperty("LastName"));
		json.put("Job", prop.getProperty("Job"));
		json.put("City", prop.getProperty("City"));

		httpRequest.body(json.toString());
		resp = httpRequest.post();
	}

	@Test(priority = 1)
	public void validateStatusCode() {
		int actualStatusCode = resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 201);
	}

	@Test(priority = 2)
	public void validateStatusLine() {
		String actualStatusLine = resp.getStatusLine();
		boolean statusCode = actualStatusLine.contains("201");
		Assert.assertEquals(statusCode, true);

	}

	@Test(priority = 3)
	public void validateResponseBody() {
		 actualPostRespBody = resp.getBody().asString();
		// System.out.println(actualRespBody);
		boolean actualNamePresentInBody = actualPostRespBody.contains("Ajit");
		Assert.assertEquals(actualNamePresentInBody, true);

	}

	@Test(priority = 4)
	public void validateContantTypeHeader() {
		String actualContentType = resp.header("Content-Type");
		Assert.assertEquals(actualContentType, "application/json; charset=utf-8");
	}

	@Test(priority = 5)
	public void validateUserIsCreated() {
		String id = resp.getBody().jsonPath().getString("id");

		httpRequest = RestAssured.given();

		resp1 = httpRequest.request(Method.GET, id);

		String getBodyByGetMethod =resp1.getBody().asString();
		
		
		

	}

	@Test(priority=8)
	public void validateAllData() {
		String FN = prop.getProperty("FirstName");
		String LN = prop.getProperty("LastName");
		String job = prop.getProperty("Job");
		String city = prop.getProperty("City");

		JsonPath data = resp1.getBody().jsonPath();
		
		String fnByget1 = resp.getBody().jsonPath().getString("First Name").toString();
		String fnByget2 = resp1.getBody().jsonPath().getString("First Name").toString();
//		String lnByget = data.getString("Last Name");
//		String cityByget = data.getString("City");
//		String jobByget = data.getString("Job");
//
	Assert.assertEquals(fnByget1, fnByget2, "First data is not matching");

//		Assert.assertEquals(LN, lnByget, "Last Name data is Matching");
//
//		Assert.assertEquals(city, cityByget, "City name is matching");
//
//		Assert.assertEquals(job, jobByget, "Job name is Job");

	}

}
