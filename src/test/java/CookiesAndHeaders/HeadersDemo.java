package CookiesAndHeaders;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.Map;

public class HeadersDemo {

	public class CookiesDEmo {

		// @Test(priority = 1)
		public void testHeaders() {

			given().when()

					.get("https://www.google.com/")

					.then().header("Content-Type", "text/html; charset=ISO-8859-1").and()
					.header("Content-Encoding", "gzip").and().header("server", "gws").log().headers();

		}

		// @Test(priority = 2) // Capture value of single headers
		public void getHeadersSingle() {

			Response res = given().when()

					.get("https://www.google.com/");
			String header = res.getHeader("Content-Type");
			System.out.println(header);
		}

		@Test(priority = 2) // Capture value of multiple headers
		public void getHeadersMultiple() {

			Response res = given().when()

					.get("https://www.google.com/");
			// get all headers info

			Headers myHeaders = res.getHeaders();
			for (Header header : myHeaders) {
				System.out.println(header.getName() + " " + header.getValue());
			}

		}
	}
}
