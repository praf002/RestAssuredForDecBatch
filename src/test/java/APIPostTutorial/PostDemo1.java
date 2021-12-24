package APIPostTutorial;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDemo1 {

	public static void main(String[] args) {

		RestAssured.baseURI="http://localhost:3000/posts";
		RequestSpecification httpRequest =RestAssured.given();
		
		
		httpRequest.header("Content-Type","application/json");
		
		JSONObject json =new JSONObject();
		
		json.put("First Name", "Varsha");
		json.put("Last Name", "Patil");
		json.put("Job", "Automation Test Engineer");
		json.put("City", "Pune");
		
		httpRequest.body(json.toString());
		
		Response resp =httpRequest.request(Method.POST);
		
		//status line
		//repoonse body
		//headers
		
		System.out.println(resp.getStatusCode());
		
		
		
		
		
		
	}

}
