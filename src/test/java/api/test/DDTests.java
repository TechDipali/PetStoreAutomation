package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import api.endpoints.UserEndPoints;
import api.paylods.User;

public class DDTests 
{

	// getAllData
	@Test(priority=1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String id, String userName, String fName, String lName, String email, String pass, String phone) 
	{
		User userPayload=new User();

		userPayload.setLastName(id);
		userPayload.setusername(userName);
		userPayload.setfirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);
		userPayload.setPassword(pass);
		userPayload.setPhone(phone);


		Response response=UserEndPoints.CreateUser(userPayload);
		//response.then().log().body();

		Assert.assertEquals(response.getStatusCode(), 200);
	}


	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testReadUser(String userName) 
	{
		
		Response response=UserEndPoints.ReadUser(userName);
		response.then().log().body();
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String userName) 
	{
		
		Response response=UserEndPoints.DeleteUser(userName);
		response.then().log().body();
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
