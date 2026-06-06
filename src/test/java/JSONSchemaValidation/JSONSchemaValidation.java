package JSONSchemaValidation;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class JSONSchemaValidation {

	  @Test
	  public void jsonSchemaValidationTest() {
		  
		        given()
		        .when()
		            .get("http://localhost:3000")
		        .then()
		            .statusCode(200)
		            .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeschema.json"));
		    }

		  
	  
}
