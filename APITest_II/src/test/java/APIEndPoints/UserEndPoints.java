package APIEndPoints;
 



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
 
import java.util.HashMap;

import org.json.JSONObject;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import Api_Payload.User;
public class UserEndPoints {
	
	public static Response createUser(User payload)
	{
		Response response =
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.post(Routes.post_url);
		return response;
	}
	public static Response createJsonUser(JSONObject payload)
	{
		Response response =
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload.toString())
				.when()
					.post(Routes.post_url);
		return response;
	}
	public static Response createHashMapUser(HashMap<String, String> data)
	{
		Response response =
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(data)
				.when()
					.post(Routes.post_url);
		return response;
	}
	
	public static Response readUser(String createdUserId)
	{
		
		Response response =
				given()
					.pathParam("createdUserId", createdUserId)
				.when()
					.get(Routes.get_url);
		return response;
	}
	public static Response updateUser(String createdUserId, User payload)
	{
		Response response =
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("createdUserId", createdUserId)
					.body(payload)
				.when()
					.put(Routes.update_url);
		return response;
	}
	public static Response updateHashmapUser(String createdUserId, HashMap<String, String> data)
	{
		Response response =
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("createdUserId", createdUserId)
					.body(data)
				.when()
					.put(Routes.update_url);
		return response;
	}
	public static Response updateJSONUser(String createdUserId, JSONObject data)
	{
		Response response =
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("createdUserId", createdUserId)
					.body(data.toString())
				.when()
					.put(Routes.update_url);
		return response;
	}
	public static Response deleteUser(String createdUserId)
	{
		Response response =
				given()
					.pathParam("createdUserId", createdUserId)
				.when()
					.delete(Routes.delete_url);
		return response;
	}
	
 
}
