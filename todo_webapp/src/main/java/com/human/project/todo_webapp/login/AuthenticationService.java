package com.human.project.todo_webapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String name, String password) {
		boolean usernameResult = name.equalsIgnoreCase("Aarav");
		boolean passwordResult = password.equalsIgnoreCase("Chandra");
		
		return usernameResult && passwordResult;
	}
}
