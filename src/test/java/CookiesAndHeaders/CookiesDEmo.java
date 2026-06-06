package CookiesAndHeaders;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.Map;

public class CookiesDEmo {

	// @Test(priority = 1)
	public void testCookies() {

		given()

				.when().get("https://www.google.com/")

				.then().cookie("AEC", "AaJma5tcw7T_9jBOUhjhjdkpMjUbWCPQvKOckvoyAHm7E8CpU8SRx_Nh0g").log().all();

	}

	// @Test(priority = 2)
	public void getCookiesInfo() {

		Response res = given()
				.when()
				.get("https://www.google.com/");

		// Get cookie info
		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of cookie======>" + cookie_value);

	}

	@Test
	public void getAllCookiesTest() {

		Response res = given()

				.when()
				.get("https://www.google.com/");

		Map<String, String> cookie_vavlues = res.getCookies();

		//System.out.println(cookie_vavlues.keySet()); //keyset for knowing all keys[__Secure-STRP,AEC,NID]
		for(String keys:cookie_vavlues.keySet()) {
			String cookie_value = res.getCookie(keys);
			System.out.println(keys+"       "+cookie_value);
		}

	}
}
