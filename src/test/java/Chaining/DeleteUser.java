package Chaining;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class DeleteUser {
	
	
	@Test
	public void deleteUserTest(ITestContext context) {
		 String bearerToken="b641943e9cdefcc6e203659c6a32e552abe0f19a8835759e4518c7f3a2867b92";
		 int id = (int) context.getAttribute("user_id"); //this should come from createuser request
		 
		 given()
		 .headers("Authorization","Bearer "+bearerToken)
		 .contentType("application/json; charset=utf-8")
		 .pathParam("id", id)
		 
		 .when()
		 .delete("https://gorest.co.in/public/v2/users/{id}")
		  
		 .then()
		 .statusCode(204)
		 .log().all();
	}

}
