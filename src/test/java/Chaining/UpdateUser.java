package Chaining;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
public class UpdateUser {

	@Test
	public void updateUserTest(ITestContext context) {
		
		 Faker faker= new Faker();
		 JSONObject data= new JSONObject();
		 data.put("name", faker.name().fullName());
		 data.put("gender", "Male");
		 data.put("email", faker.internet().emailAddress());
		 data.put("status", "active");
		 
		 String bearerToken="b641943e9cdefcc6e203659c6a32e552abe0f19a8835759e4518c7f3a2867b92";
		 int id = (int) context.getAttribute("user_id"); //this should come from createuser request
		 given()
		 .headers("Authorization","Bearer "+bearerToken)
		 .contentType("application/json; charset=utf-8")
		 .body(data.toString())
		 .pathParam("id", id)
		 
		 .when()
		 .put("https://gorest.co.in/public/v2/users/{id}")
		  
		 .then()
		 .statusCode(200)
		 .log().all();
		}
		
		
	
}
