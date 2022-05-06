package RestAssured;

import org.asynchttpclient.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class PostApi 
{
	@Test
	public void PostApiAutomation()
	{
		//https://reqres.in/api/users
		RestAssured.baseURI="https://reqres.in/api"; //base uri
		
		RequestSpecification https=RestAssured.given();
	
		JSONObject inputBody=new JSONObject();
		inputBody.put("name", "Sushant");
		inputBody.put("job", "QA");
		
		https.header("Content-Type", "application/json; charset=utf-8");
		
		https.body(inputBody.toJSONString());
		
		Response response=(Response) https.request(Method.POST, "/users");
		String responseobj = response.getResponseBody();
		
		System.out.println("My response is : "+ responseobj);//endpoint:users
		
		
	
	
	}
}
