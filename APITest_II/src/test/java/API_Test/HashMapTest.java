package API_Test;

	import java.util.HashMap;
	 
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	 
	import APIEndPoints.UserEndPoints;
	import Api_Payload.User;
	import io.restassured.response.Response;
	 
	 
	public class HashMapTest {
		
		String CreatedUserId;
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		@BeforeClass
		public void SetUp() {
		
		data.put("name", "syed");
		data.put("job", "engineer");
		
		}
		
		@Test(priority = 1)
		public void testCreateUser() {
	 
			Response response = UserEndPoints.createHashMapUser(data);
			
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
			
			Response response=UserEndPoints.updateHashmapUser(CreatedUserId, data);
			
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

