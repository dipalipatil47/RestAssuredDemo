package MultipleWaysPostRequestGenerates;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.*;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class MultipleWaysPostRequestGenerates {
	
	//1) Approach1- Using Hashmap create post request
	
	//@Test(priority = 1)
    public void testPostUsingHashmap() {
    		
		HashMap data= new HashMap();
		data.put("name","Dipali Patil");
		data.put("email", "dipali@gmail.com");
		String courseArr[]= {"Automation Testing","c#"};
		data.put("course",courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
	    .statusCode(201)
	    .body("name",equalTo("Dipali Patil"))
	    .body("email",equalTo("dipali@gmail.com"))
	    .body("course[0]",equalTo("Automation Testing"))
	    .body("course[1]",equalTo( "c#"))
	    .log().all();
		
    }
    // Approach 2: USING ORJ.JSON DEPENDENCY
   // @Test(priority = 1)
    public void testPostUsingorgJson() {
    	
    		JSONObject data= new JSONObject();
    		data.put("name","Manali");
    		data.put("email", "dipali12@gmail.com");
    		String courseArr[]= {"Automation Testing","c#"};
    		data.put("course",courseArr);
    		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
	    .statusCode(201)
	    .body("name",equalTo("Manali"))
	    .body("email",equalTo("dipali12@gmail.com"))
	    .body("course[0]",equalTo("Automation Testing"))
	    .body("course[1]",equalTo( "c#"))
	    .log().all();
    }
    
    // Approach 3 USING POJO CLASS
    //@Test(priority = 1)
    public void testPostUsinPOJO() {
    	
    		  Post_POJO data= new Post_POJO();
    		  data.setName("AShitosh");
    		  data.setEmail("dips@gmail.com");
    		  
    		  String [] courarr= {"java","c"};
    		  data.setCourse(courarr);
    		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
	    .statusCode(201)
	    .body("name",equalTo("AShitosh"))
	    .body("email",equalTo("dips@gmail.com"))
	    .body("course[0]",equalTo("java"))
	    .body("course[1]",equalTo( "c"))
	    .log().all();
    }
    
    
    // Approach 4 USING External JSON FILE
    @Test(priority = 1)
    public void testPostUsingExternalJSONFile() throws FileNotFoundException {
    	
    	      File f= new File(".\\body.json");
    	      FileReader fr= new FileReader(f);
    	      
    	      JSONTokener jt= new JSONTokener(fr);
    	      JSONObject data= new JSONObject(jt);
    	      
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
	    .statusCode(201)
	    .body("name",equalTo("Priya Singh"))
	    .body("email",equalTo("priya@gmail.com"))
	    .body("course[0]",equalTo("C"))
	    .body("course[1]",equalTo( ".NET"))
	    .log().all();
    }
    
	//@Test(priority = 2)
	void testDelete() {
		given()
		
		.when()
		.delete("http://localhost:3000/students/0073")
		.then()
		.statusCode(200)
		.log().all();
	}
	
}
