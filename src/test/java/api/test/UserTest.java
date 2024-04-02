package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.paylods.User;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setUp() 
	{
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setusername(faker.name().username());
		userPayload.setfirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger= (Logger) LogManager.getLogger(this.getClass());
	}
	
	@Test (priority = 1)
	public void testUserPost() 
	{
		logger.info("*************Creating User*******************");
		Response response=UserEndPoints.CreateUser(userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*************User Created*******************");
	}
	
	
	@Test(priority = 2)
	public void testGetUser() 
	{
		logger.info("*************Reading User*******************");
		Response response=UserEndPoints.ReadUser(this.userPayload.getusername());
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*************User Info Displayed*******************");
	}
	
	
	@Test(priority = 3)
	public void testUpdateUser() 
	{
		logger.info("*************Updating User*******************");
		userPayload.setfirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		Response response=UserEndPoints.UpdateUser(userPayload, this.userPayload.getusername());
		response.then().log().body().statusCode(200);
		
		logger.info("*************User Updated*******************");
	}
	
	@Test(priority = 4)
	public void testDeleteUser() 
	{
		logger.info("*************Deleting User*******************");
	Response response=UserEndPoints.DeleteUser(this.userPayload.getusername());
	 response.then().log().all();
	 
	 Assert.assertEquals(response.getStatusCode(), 200);
	
	 logger.info("*************User Deleted*******************");
	}
	
}
