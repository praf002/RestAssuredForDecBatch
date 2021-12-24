package APITestLayer;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDemo1 {

	public static void main(String[] args) {
		//Specify the Base URI
			
		RestAssured.baseURI="http://localhost:3000/posts/2";
		// get request Specification object 
		RequestSpecification httpRequest =RestAssured.given();
		
		// we haave to hit the request
		Response resp =httpRequest.request(Method.GET);
		
		System.out.println(resp.getStatusLine());
		String a=resp.header("Content-Type");
		System.out.println(a);

		Long b=resp.getTime();
		System.out.println(b);
	
		if(b<=500)
		{
			System.out.println("test case is pass");
		}
	
		
	
	
	}

}
