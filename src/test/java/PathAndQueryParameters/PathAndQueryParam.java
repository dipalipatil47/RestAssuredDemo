package PathAndQueryParameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

public class PathAndQueryParam {

	@Test
	public void testPathAndQueryParam() {

		given()
		.header("x-api-key", "reqres_e7ad6743b9044dfe8d4f99c43e18388e")
		.pathParam("myPath", "users") //path parameters
		.queryParam("page",2)
		.queryParam("id",7)
		
		.when()
		.get("https://reqres.in/api/{myPath}")
		
		.then()
	    .statusCode(200)
	    .log().all();

	}
}
