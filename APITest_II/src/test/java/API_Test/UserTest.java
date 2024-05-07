package API_Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import APIEndPoints.UserEndPoints;
import Api_Payload.User;
import io.restassured.response.Response;
 
public class UserTest {
	
	User UserPayload;
	User UserPayload1;
	String CreatedUserId;
	
	@BeforeClass
	public void SetUp() {
	
		UserPayload=new User();
		UserPayload1=new User();
		
		//UserPayload.setId(599);
		UserPayload.setFirst_name("sai");
		UserPayload.setLast_name("kumar");
		UserPayload.setEmail("sai1212@gmail.com");
		UserPayload.setName("saiKumar121");
		UserPayload.setJob("tester");
		
		
		UserPayload1.setFirst_name("Sai");
		UserPayload1.setLast_name("kumar");
		UserPayload1.setEmail("sai121@gmail.com");
		UserPayload1.setName("saikumar");
		UserPayload1.setJob("tester");
	}
	
	
	@Test(priority = 1)
	public void testCreateUser() {
		Response response = UserEndPoints.createUser(UserPayload);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		
		CreatedUserId = response.then().extract().path("id");
		
		System.out.println(CreatedUserId);
	}
 
	
	@Test(priority = 2,dependsOnMethods = {"testCreateUser"})
	public void testGetUser() {
	    Response response = UserEndPoints.readUser(CreatedUserId);
	    System.out.println(CreatedUserId);
	    response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 404);
	    }
	
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		Response response=UserEndPoints.updateUser(CreatedUserId, UserPayload1);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 4, dependsOnMethods = {"testUpdateUser"})
	public void testDeleteUser() {
		Response response=UserEndPoints.deleteUser(CreatedUserId);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 204);
	}
	
	
	
 
	
 
}