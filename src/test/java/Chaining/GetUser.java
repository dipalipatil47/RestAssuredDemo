package Chaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class GetUser {

	@Test
	public void testGetUser(ITestContext context) {
		
		int id = (int) context.getAttribute("user_id"); //this should come from createuser request
		String bearer_token="b641943e9cdefcc6e203659c6a32e552abe0f19a8835759e4518c7f3a2867b92";
		
		given()
		.headers("Authorization","Bearer "+bearer_token)
		.pathParam("id", id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	
	}

}
