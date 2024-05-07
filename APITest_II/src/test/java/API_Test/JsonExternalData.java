package API_Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import APIEndPoints.UserEndPoints;
import io.restassured.response.Response;

public class JsonExternalData {

	JSONObject data;
	String CreatedUserId;
	@BeforeClass
	public void setUpData() throws FileNotFoundException {
		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		data = new JSONObject();
	}
	
	@Test
	public void testCreateUser() {
		 
		Response response = UserEndPoints.createJsonUser(data);
		
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
		
		Response response=UserEndPoints.updateJSONUser(CreatedUserId, data);
		
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
