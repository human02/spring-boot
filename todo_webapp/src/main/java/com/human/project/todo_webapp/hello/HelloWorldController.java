package com.human.project.todo_webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?\n";
	}

	
	@RequestMapping("/say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First HTML Page - Changed</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html page with body - Changed");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
		
	}
	
	//Add JSP page
	@RequestMapping("say-hello-jsp")
	public String sayHelloJSP() {
		return("sayHello");
	}
}
