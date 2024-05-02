package APIEndPoints;
 
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.validator.PublicClassValidator;

import com.aventstack.extentreports.gherkin.model.Given;
 
import io.restassured.http.ContentType;
 
public class UserEndPoints {
	
	@Test
	public void getBookDetails() {
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.get(Routes.get_url)
		.then()
			.statusCode(200)
			.log().all();
	}
	@Test
	
	//test cases will fail due to incorrect title assumption in the post method 
	public void postBookName() {
		String title = "HarryPorter";
		given()
			.contentType(ContentType.JSON)
			.body(title)
		.when()
			.post(Routes.post_url)
		.then()
		.statusCode(200)
		.log().all();
	}
	// this test case is also will fail 
	// this was written when the about method runs accurately and book is posted in to the swagger 
	@Test(dependsOnMethods = {"postBookName"} )
	public void getnewlyAddedBook() {
		given()	
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.get(Routes.get_url)
		.then()
		.body("title",equalTo("HarryPorter"))
		.statusCode(200)
		.log().all();
	}
	
}