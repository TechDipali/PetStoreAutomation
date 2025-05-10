package api.endpoints;

import static io.restassured.RestAssured.given;

import api.paylods.Store;
import io.restassured.response.Response;

public class StoreEndPoints {

	public static Response PlacePetOrder(Store payload) 
	{
	Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.when()
		.post(Routes.storePost_URL);
	
	return response;
		
	} 
	
	public static Response GetOrder(int orderId) 
	{
	Response response=given()
		.pathParam("orderId", orderId)
		.when()
		.get(Routes.storeGet_URL);
		
	return response;
	}
	
	public static Response DeleteOrder(int orderId) 
	{
	Response response=given()
		.pathParam("orderId", orderId)
		.when()
		.delete(Routes.storeDelete_URL);
		
	return response;
	}
	
}
