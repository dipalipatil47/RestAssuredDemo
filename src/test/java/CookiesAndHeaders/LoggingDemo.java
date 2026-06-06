package CookiesAndHeaders;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
public class LoggingDemo {
	
	@Test
	public void logTest() {
		
		given()
		.header("x-api-key", "reqres_e7ad6743b9044dfe8d4f99c43e18388e")
		.when()
		.get("https://reqres.in/api/users?page=2&id=7")
		.then()
		//.log().body()
		//.log().cookies()
		.log().headers()
		//.log().all()
		;
		
	}

}
