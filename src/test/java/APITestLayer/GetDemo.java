package APITestLayer;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDemo {

	public static void main(String[] args) {
		// Specify the Base URl
		RestAssured.baseURI="http://localhost:3000/posts/10";
		
		//request specification  of the request that we have to sent to server
		RequestSpecification httpRequest=RestAssured.given();
		
		// then we have pass the request type
		Response resp =httpRequest.request(Method.GET);
		
		int statuscode =resp.getStatusCode();
		
		System.out.println(statuscode);
		
		String a=resp.getBody().asString();
		System.out.println(a);
		
		
	}

}
