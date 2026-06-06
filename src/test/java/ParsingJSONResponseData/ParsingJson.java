package ParsingJSONResponseData;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJson {

	//@Test(priority = 1)
	public void testJsonRes() {

		given()
		  .contentType("application/json")
		
		.when()
		   .get("http://localhost:3000/store")

				.then()
				.statusCode(200)
				.body("products[1].name",equalTo("Mouse"));
	}
	//@Test(priority = 1) //approch 2
		public void testJsonResData() {

		Response res=given()
			  .contentType("application/json")
			
			.when()
			   .get("http://localhost:3000/store");
		
		       Assert.assertEquals(res.getStatusCode(),200);
		       Assert.assertEquals(res.header("content-type"), "application/json");
		       
		       String p=res.jsonPath().get("products[1].name").toString();
		       Assert.assertEquals(p,"Mouse"); 
					
		}
		
		@Test(priority = 1) //approch 2
		public void testJsonResData2() {

		Response res=given()
			  .contentType(ContentType.JSON)
			
			.when()
			   .get("http://localhost:3000/store");
		
		      JSONObject jo= new JSONObject(res.asString()); //converting response to json object type
		      boolean status=false;
		      
		      for(int i=0;i<jo.getJSONArray("books").length();i++) {
		    	 String title= jo.getJSONArray("books").getJSONObject(i).get("title").toString();
		    	 System.out.println(title);
		    	 
		    	 if(title.equals("Selenium Automation")) {
		    		 status=true;
		    		 break;
		    	 }
		    	 
		      }
		      Assert.assertEquals(status, true);		
		}
	
	

}
