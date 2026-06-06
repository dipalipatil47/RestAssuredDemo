package Chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {

	@Test
	public void test_CreateUser(ITestContext context) {
		
	 Faker faker= new Faker();
	 JSONObject data= new JSONObject();
	 data.put("name", faker.name().fullName());
	 data.put("gender", "Female");
	 data.put("email", faker.internet().emailAddress());
	 data.put("status", "inactive");
	 
	 String bearerToken="b641943e9cdefcc6e203659c6a32e552abe0f19a8835759e4518c7f3a2867b92";
	 int id= given()
	 .headers("Authorization","Bearer "+bearerToken)
	 .contentType("application/json; charset=utf-8")
	 .body(data.toString())
	 
	 .when()
	 .post("https://gorest.co.in/public/v2/users")
	 .jsonPath().getInt("id");
	 System.out.println("Generated id:"+id);
	 
	 context.setAttribute("user_id", id);
	}
	
}
