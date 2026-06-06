package ParsingJSONResponseData;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ParsingXML {

	@Test
	public void testXMLres() {
		
		given()
		
		.when()
		.get("http://localhost:3000/store")
		
		.then();
		
	}
}
