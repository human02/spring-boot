package com.aarav.bootjpa_eg;

import com.aarav.bootjpa_eg.dao.UserRepository;
import com.aarav.bootjpa_eg.entities.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootjpaEgApplication {

	public static void main(String[] args) {
		// Required to the get a bean
		ApplicationContext context = SpringApplication.run(BootjpaEgApplication.class, args);
		// Required to call our bean
		UserRepository userRepo = context.getBean(UserRepository.class);

		// Creating a user that will be added to the database
		User user = new User();
		user.setName("John");
		user.setCity("North Pole");
		user.setAddress("Arctic");

		// Saving it to the database
		User result1 = userRepo.save(user);
		System.out.println("\n\n" + result1 + "\n\n" + "Completed" + "\n");

		// Delete an entry from the table using 'id'
		System.out.println("\n Please enter a valid id :\t");
		int deleteID = Integer.parseInt(System.console().readLine());
		try {
			userRepo.deleteById(deleteID);
			System.out.println("Sucessfully deleted entry with ID = " + deleteID);
		} catch (Exception e) {
			System.out.println("Please enter correct ID, your ID is incorrect\n\n");
		}

	}

}
