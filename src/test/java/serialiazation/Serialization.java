package serialiazation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import MultipleWaysPostRequestGenerates.Post_POJO;

// Serialization----> POJO----> JSON

//@Test
public class Serialization {

	public void covertPOJOToJson() throws JsonProcessingException {

		// Created java object using pojo class
		Student stud = new Student(); // POJO JAVA OBject
		stud.setName("AShitosh");
		stud.setEmail("dips@gmail.com");

		String[] courarr = { "java", "c" };
		stud.setCourse(courarr);

		// convert java object to JSON object-------> Serialization
		ObjectMapper obj = new ObjectMapper();
		String jsonData = obj.writerWithDefaultPrettyPrinter().writeValueAsString(stud);
		System.out.println(jsonData);

	}

	// De-serialization convert JSON---->POJO

	@Test
	public void covertJsonToPOJO() throws JsonProcessingException {

		
		String jsonData="{\r\n"
				+ "  \"name\" : \"AShitosh\",\r\n"
				+ "  \"email\" : \"dips@gmail.com\",\r\n"
				+ "  \"course\" : [ \"java\", \"c\" ]\r\n"
				+ "}";
		
		ObjectMapper obj= new ObjectMapper();
		Student s=obj.readValue(jsonData,Student.class);
		
		System.out.println("Name:"+s.getName());
		System.out.println("Email:"+s.getEmail());
		System.out.println("Course 1:"+s.getCourse()[0]);
		System.out.println("Course 2:"+s.getCourse()[1]);

	}

}
