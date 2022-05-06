package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetApi 
{
	@Test
	public void GetApiAutomation()
	{
		//https://reqres.in/api/users/2    
		
		RestAssured.baseURI="https://reqres.in/api/users";  //uri
		
		RequestSpecification http=RestAssured.given();
		
		Response response= http.request(Method.GET, "/2");
		
		String responseObject= response.getBody().asString();
		
		System.out.println("My response is : \n"+responseObject);
		
		int statuscode= response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
		
		String Statusline=response.getStatusLine();
		System.out.println("my Status line : "+Statusline);
	}
}
