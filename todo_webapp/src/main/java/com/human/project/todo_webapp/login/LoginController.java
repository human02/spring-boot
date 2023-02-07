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
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String loginPage() {
//		print not recommended for Prod
//		System.out.println("The name parameter passed via address is:" + " "+name);		
		return("login");
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String welcomePage(@RequestParam String name,@RequestParam String password, ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		logger.debug("Name passed by request Param = ",name);
		return("welcomePage");
	}
}
