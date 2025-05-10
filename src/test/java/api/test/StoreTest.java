package api.test;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.paylods.Store;
import io.restassured.response.Response;

public class StoreTest
{
	Faker faker;
	Store storePayload;
	public Logger logger;
	
	@BeforeClass
	public void setUp() 
	{
		faker=new Faker();
		storePayload=new Store();
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setQuantity(100);
		storePayload.setShipDate(faker.date().hashCode());
		storePayload.setStatuString("placed");
		storePayload.setCompleted(false);
		
		logger= (Logger) LogManager.getLogger(this.getClass());
	}
	
	
	// post- place order
	@Test(priority=1)
	public void testStorePost() 
	{
	  Response	response=StoreEndPoints.PlacePetOrder(storePayload);
		
	  response.then().log().body();
	  
	  assertEquals(response.getStatusCode(), 200);
		
	}
	
	// get order using orderId
	@Test(priority = 2)
	public void testStoreGet() {
		
	 Response response=StoreEndPoints.GetOrder(this.storePayload.getId());
		
	 response.then().log().body();
	 
	 assertEquals(response.getStatusCode(), 200);
	 
	}
	

	// get order using orderId
		@Test(priority = 3)
		public void testStoreDelete() {
			
		 Response response=StoreEndPoints.DeleteOrder(this.storePayload.getId());
			
		 response.then().log().body();
		 
		 assertEquals(response.getStatusCode(), 200);
		 
		}
	
}
