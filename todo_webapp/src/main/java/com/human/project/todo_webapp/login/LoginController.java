package com.human.project.todo_webapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());

//	Created but not initiated and we can't use new keyword, best way to use constructor injection
	private AuthenticationService authenticationResult;

	public LoginController(AuthenticationService authenticationResult) {
		super();
		this.authenticationResult = authenticationResult;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage() {
		logger.debug("Entered get page");
//		print not recommended for Prod
		return ("login");
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		logger.debug("Name passed by request param = ",name);
		if (authenticationResult.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return ("welcomePage");
		}
		model.put("errorMessage","Invalid Credentials! Please try Again..");
		return ("login");

	}
}
