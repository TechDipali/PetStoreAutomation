package api.endpoints;
import static io.restassured.RestAssured.given;

import api.paylods.User;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response CreateUser(User payload) 
	{
	   Response response=given()
		.contentType("application/json")
		.accept("application/json")
        .body(payload)
		.when()
		.post(Routes.post_URL);
	   
	   return response;
	}
	
	public static Response ReadUser(String userName) 
	{
	   Response response=given()
			   .pathParam("UserName", userName)
		.when()
		.get(Routes.Get_URL);
	   
	   return response;
	}
	
	public static Response UpdateUser(User payload, String userName) 
	{
	   Response response=given()
		.pathParam("UserName", userName)
		.contentType("application/json")
		.accept("application/json")
        .body(payload)
		.when()
		.put(Routes.Put_URL);
	   
	   return response;
	}
	
	public static Response DeleteUser(String userName) 
	{
	   Response response=given()
			   .pathParam("UserName", userName)
		.when()
		.delete(Routes.Delete_URL);
	   
	   return response;
	}
	

}
