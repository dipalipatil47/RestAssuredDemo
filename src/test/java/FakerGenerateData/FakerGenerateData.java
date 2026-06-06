package FakerGenerateData;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerGenerateData {

	@Test
	public void FakerDataTest() {

		Faker faker = new Faker();
		String fullname = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastname = faker.name().lastName();

		String username = faker.name().username();
		String password = faker.internet().password();

		String phoneno = faker.phoneNumber().cellPhone();
		String email = faker.internet().safeEmailAddress();
		
		System.out.println("Full name is"+fullname);
		System.out.println("First name is"+firstName);
		System.out.println("Last name is"+lastname);
		System.out.println("Username name is"+username);
		System.out.println("cellPhone is"+phoneno);
		System.out.println("Email is"+email);

	}

}
