package api.endpoints;
import static io.restassured.RestAssured.given;

import api.paylods.Pet;
import io.restassured.response.Response;
public class PetEndPoints 
{
	
	public Response AddPet(Pet payload) 
	{
	Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.when()
		.post(Routes.petPost_URL);
		
	return response;
	}
	
	public Response FindPet(String findByStatus) 
	{
	Response	response=given()
		.pathParam("findByStatus", findByStatus)
		.when()
        .get(Routes.petGet_URL);
		
     	return response;
		
	}
	
	public Response UpdatePet(Pet Payload) 
	{
		Response response=given()
				.contentType("application/json")
				.accept("application/json")
		        .body(Payload)
				.when()
				.put(Routes.petPut_URL);
			   
			   return response;
		
		
	}
	
	

}
