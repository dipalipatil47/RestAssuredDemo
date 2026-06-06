package AuthenticationPack;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class AuthenticationTest {
	
	@Test(priority = 1)
	public void authTestBasic() {

	given()
	  .auth().basic("postman", "password")
	.when()
	.get("https://postman-echo.com/basic-auth")
	.then()
	.statusCode(200)
	.body("authenticated", equalTo(true))
	.log().all()
	;
	}
	
	@Test(priority = 2)
		public void authTestDigest() {

		given()
		  .auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all()
		;
		}
		
		@Test(priority = 3)
			public void authTestPreempive() {

			given()
			 .auth().preemptive().basic("postman", "password")
			.when()
			.get("https://postman-echo.com/basic-auth")
			.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all()
			;
			}
		
	@Test(priority = 4)
		public void authTestBearer() {
		
	    String bearerToken= "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";
			
		given()
		 .headers("Authorization","Bearer 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")
		 
		.when()
		.get("https://github.com/settings/personal-access-tokens")
		.then()
		.statusCode(200)
		//body("authenticated", equalTo(true))
		.log().all()
		;
		
		}
		
		@Test(priority = 5)
		void testOAuth1() {
			
			given()
			.auth().oauth2("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")

			.when()
			.get("https://github.com/settings/personal-access-tokens")
			.then()
			.statusCode(200)
			.log().all()
			;
		}
		
		@Test(priority = 6)
		void testAPIKeys() {
			
			given()
			.queryParam("appid","c971c05a39b8bfb31039690f648b9151") // appid is APIKEY
			.pathParam("mypath","api_keys")
			.queryParam("q", "delhi")
			
			.when()
			.get("https://home.openweathermap.org/api_keys?{mypath}")
			.then()
			.statusCode(200)
			.log().all()
			;
		}
		
	}

