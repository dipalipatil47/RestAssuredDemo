package HttpRequestDemo;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

/*given()
when()
then() */

public class HTTPRequest {
	int id;

	@Test(priority = 1)
	void getUsers() {

		given().header("x-api-key", "reqres_e7ad6743b9044dfe8d4f99c43e18388e")

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
	}

	@Test(priority = 2)
	void createUser() {

		HashMap data = new HashMap ();
		data.put("name", "morphes");
		data.put("job", "leaderd");
		
		id=given()
		.header("x-api-key", "reqres_e7ad6743b9044dfe8d4f99c43e18388e")
				.contentType("application/json")
				.body(data)
				
				.when()
				 .post("https://reqres.in/api/users")
				 
				 .jsonPath().getInt("id");

				//.then()
				  // .statusCode(201)
				   //.log().all();
				   
	}
	
	@Test(priority = 3,dependsOnMethods = ("createUser"))
	void updateUser() {
		
		HashMap data = new HashMap ();
		data.put("name", "ashu");
		data.put("job", "Teacher");
		
		given()
		.header("x-api-key", "reqres_e7ad6743b9044dfe8d4f99c43e18388e")
				.contentType("application/json")
				.body(data)
				
				.when()
				 .put("https://reqres.in/api/users/"+id)
		
		.then()
		  .statusCode(200)
		   .log().all();
		
	}
	@Test(priority = 4)
	void deleteUser() {
			
		given()
		.header("x-api-key", "reqres_e7ad6743b9044dfe8d4f99c43e18388e")
				.contentType("application/json")
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		 .statusCode(204)
		 .log().all(); // give headers information
		
	}

}
