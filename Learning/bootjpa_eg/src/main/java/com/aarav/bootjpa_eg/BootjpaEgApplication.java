package com.aarav.bootjpa_eg;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import com.aarav.bootjpa_eg.dao.UserRepository;
import com.aarav.bootjpa_eg.entities.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootjpaEgApplication {

	public static void main(String[] args) throws IOException {
		// Required to the get a bean
		ApplicationContext context = SpringApplication.run(BootjpaEgApplication.class, args);
		// Required to call our bean
		UserRepository userRepo = context.getBean(UserRepository.class);
		boolean tillWhen = true;

		while (tillWhen) {
			System.out.println("\n*************----- Welcome to CLI -----*************\n\nChoose an option\n");
			System.out.print(
					"1  - Create\n2  - Read\n3  - Read All\n4  - Update\n5  - Delete\n6  - Delete All\n7  - Find by Name\n8  - Find by City\n9  - Find by State\n10 - Find by City or State\n11 - Find by City and State\n12 - Find all entries whose name starts with\n0  - Exit\n\n---> ");
			int choice = Integer.parseInt(System.console().readLine());
			// If we put it before while then the entry keep on getting overwritten.
			User user = new User();
			switch (choice) {
			case 1:
				// Insert a single user in the table.
				System.out.print("\nEnter name: - \t");
				String name = System.console().readLine();
				System.out.print("Enter city: - \t");
				String city = System.console().readLine();
				System.out.print("Enter state: -  ");
				String add = System.console().readLine();

				user.setName(name);
				user.setCity(city);
				user.setState(add);
				try {
					User result1 = userRepo.save(user);
					System.out.println("\nSuccessfully added.\nID assocaited with this user = " + result1.getId());
				} catch (Exception e) {
					System.out.println("Please enter correct ID, your ID is incorrect\n");
				}
				break;

			case 2:
				// Reading the value associated with an ID.
				try {
					System.out.print("\nPlease enter a valid id : ");
					int findID = Integer.parseInt(System.console().readLine());
					Optional<User> foundUser = userRepo.findById(findID);
					if (foundUser.isEmpty() == false) {
						System.out.println("Sucessfully found the entry:\n\t" + foundUser);
					} else {
						System.out.println(
								"No record present that is associated with this ID, please try a different ID. ");
					}

				} catch (Exception e) {
					System.out.println("No such entry present.\n");
				}
				break;

			case 3:
				// Reading all the entries of the table.
				try {
					System.out.println("\nAll the entries are as follows: ");
					Iterable<User> foundUser = userRepo.findAll();
					for (User eachUser : foundUser) {
						System.out.println("   " + eachUser.toString());
					}
				} catch (Exception e) {
					System.out.println("No entry present.\n");
				}
				break;

			case 4:
				// Update a single user entry in the table.
				System.out.print("Enter the ID associated to which you want to update the data: -  ");
				int updateID = Integer.parseInt(System.console().readLine());
				Optional<User> foundUser = userRepo.findById(updateID); // Getting the same object to overwrite.
				User userUpdate = new User();
				userUpdate = foundUser.get();
				System.out.print("Enter name: - \t");
				String newName = System.console().readLine();
				System.out.print("Enter city: - \t");
				String newCity = System.console().readLine();
				System.out.print("Enter state: -  ");
				String newAdd = System.console().readLine();

				userUpdate.setName(newName);
				userUpdate.setCity(newCity);
				userUpdate.setState(newAdd);
				try {
					User result1 = userRepo.save(userUpdate);
					System.out.println("\nSuccessfully added.\nID assocaited with this user = " + result1.getId());
				} catch (Exception e) {
					System.out.println("Please enter correct ID, your ID is incorrect\n");
				}
				break;

			case 5:
				// Delete an entry from the table using 'id'.
				System.out.print("\nPlease enter a valid id : ");
				int deleteID = Integer.parseInt(System.console().readLine());
				try {
					userRepo.deleteById(deleteID);
					System.out.println("Sucessfully deleted entry with ID = " + deleteID);
				} catch (Exception e) {
					System.out.println("Please enter correct ID, your ID is incorrect\n");
				}
				break;

			case 6:
				// Deleting All the entries at once.
				try {
					userRepo.deleteAll();
					System.out.println("Sucessfully deleted all entries\n");
				} catch (Exception e) {
					System.out.println("No entry present to delete\n\n");
				}
				break;

			case 7:
				// Reading the value(s) associated with a name.
				try {
					System.out.print("\nPlease enter a valid name : ");
					String findName7 = System.console().readLine();
					List<User> foundUser7 = userRepo.findByName(findName7);
					if (foundUser7.isEmpty() == false) {

						System.out.println("Sucessfully found the entry:\n");
						foundUser7.forEach(eachUser7 -> System.out.println(eachUser7));
					} else {
						System.out.println(
								"No record present that is associated with this name, please try a different name. ");
					}

				} catch (Exception e) {
					System.out.println("No such entry present.\n");
				}
				break;

			case 8:
				// Reading the value(s) associated with a city.
				try {
					System.out.print("\nPlease enter a valid city : ");
					String findCity8 = System.console().readLine();
					List<User> foundUser8 = userRepo.findByCity(findCity8);
					if (foundUser8.isEmpty() == false) {

						System.out.println("Sucessfully found the entry:\n");
						foundUser8.forEach(eachUser8 -> System.out.println(eachUser8));
					} else {
						System.out.println(
								"No record present that is associated with this city, please try a different city. ");
					}

				} catch (Exception e) {
					System.out.println("No such entry present.\n");
				}
				break;

			case 9:
				// Reading the value(s) associated with a state.
				try {
					System.out.print("\nPlease enter a valid state : ");
					String findState9 = System.console().readLine();
					List<User> foundUser9 = userRepo.findByState(findState9);
					if (foundUser9.isEmpty() == false) {

						System.out.println("Sucessfully found the entry:\n");
						foundUser9.forEach(eachUser9 -> System.out.println(eachUser9));
					} else {
						System.out.println(
								"No record present that is associated with this state, please try a different state. ");
					}

				} catch (Exception e) {
					System.out.println("No such entry present.\n");
				}
				break;
			case 10:
				// Reading the value(s) associated with a state or city.
				try {
					System.out.print("\nPlease enter a valid state : ");
					String findState10 = System.console().readLine();
					System.out.print("\nPlease enter a valid city : ");
					String findCity10 = System.console().readLine();
					List<User> foundUser10 = userRepo.findByCityOrState(findCity10, findState10);
					if (foundUser10.isEmpty() == false) {

						System.out.println("Sucessfully found the entry:\n");
						foundUser10.forEach(eachUser10 -> System.out.println(eachUser10));
					} else {
						System.out.println(
								"No record present that is associated with such inputs, please try with different inputs. ");
					}

				} catch (Exception e) {
					System.out.println("No such entry present.\n");
				}
				break;

			case 11:
				// Reading the value(s) associated with a state and city.
				try {
					System.out.print("\nPlease enter a valid state : ");
					String findState11 = System.console().readLine();
					System.out.print("\nPlease enter a valid city : ");
					String findCity11 = System.console().readLine();
					List<User> foundUser11 = userRepo.findByCityAndState(findCity11, findState11);
					if (foundUser11.isEmpty() == false) {

						System.out.println("Sucessfully found the entry:\n");
						foundUser11.forEach(eachUser11 -> System.out.println(eachUser11));
					} else {
						System.out.println(
								"No record present that is associated with such inputs, please try with different inputs. ");
					}

				} catch (Exception e) {
					System.out.println("No such entry present.\n");
				}
				break;

			case 12:
				// Reading the value(s) associated with a name prefix.
				try {
					System.out.print("\nPlease enter a valid name-prefix : ");
					String findPrefixName12 = System.console().readLine();
					List<User> foundUser12 = userRepo.findByNameStartingWith(findPrefixName12);
					if (foundUser12.isEmpty() == false) {

						System.out.println("Sucessfully found the entry:\n");
						foundUser12.forEach(eachUser12 -> System.out.println(eachUser12));
					} else {
						System.out.println(
								"No record present that is associated with such inputs, please try with different inputs. ");
					}

				} catch (Exception e) {
					System.out.println("No such entry present.\n");
				}
				break;
			case 13:
				// Reading the value(s) associated with a name prefix.
				try {
					System.out.print("\nPlease enter a valid name: ");
					String findName13 = System.console().readLine();
					List<User> foundUser13 = userRepo.getByName(findName13);
					if (foundUser13.isEmpty() == false) {

						System.out.println("Sucessfully found the entry:\n");
						foundUser13.forEach(eachUser13 -> System.out.println(eachUser13));
					} else {
						System.out.println(
								"No record present that is associated with such inputs, please try with different inputs. ");
					}

				} catch (Exception e) {
					System.out.println("No such entry present.\n");
				}
				break;
			case 0:
				System.out.println(
						"\nExit Initiated..\nThank You for using the application, Until next time!!\n************------------------------------************\n");
				tillWhen = false;
				break;

			default:
				break;
			}
		}

	}

}
