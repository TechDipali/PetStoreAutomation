package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.paylods.User;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	// Create method to get data from properties file .
	public static ResourceBundle getURL()
	{
		ResourceBundle routes= ResourceBundle.getBundle("routes"); // name of the properties file
		return routes;
	}
	
	public static Response CreateUser(User payload) 
	{
		//get URL
		String post_URL=getURL().getString("post_URL");
		
	   Response response=given()
		.contentType("application/json")
		.accept("application/json")
        .body(payload)
		.when()
		.post(post_URL);
	   
	   return response;
	}
	
	public static Response ReadUser(String userName) 
	{
		//get URL
				String get_URL=getURL().getString("get_URL");
		
	   Response response=given()
			   .pathParam("UserName", userName)
		.when()
		.get(get_URL);
	   
	   return response;
	}
	
	public static Response UpdateUser(User payload, String userName) 
	{
		//get URL
				String update_URL=getURL().getString("update_URL");
				
	   Response response=given()
		.pathParam("UserName", userName)
		.contentType("application/json")
		.accept("application/json")
        .body(payload)
		.when()
		.put(update_URL);
	   
	   return response;
	}
	
	public static Response DeleteUser(String userName) 
	{
		//get URL
				String delete_URL=getURL().getString("delete_URL");
				
	   Response response=given()
			   .pathParam("UserName", userName)
		.when()
		.delete(delete_URL);
	   
	   return response;
	}
	

}
