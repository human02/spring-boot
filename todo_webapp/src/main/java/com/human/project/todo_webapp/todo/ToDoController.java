package com.human.project.todo_webapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	public ToDoController(ToDoService todoService) {
		super();
		this.todoService = todoService;
	}

	private ToDoService todoService;
		
	
	@RequestMapping("list")
	public String listAllTodos(ModelMap model) {
		List<ToDo> todos = todoService.findByUser("Aarav");
		model.addAttribute("todos", todos);
		
		return "todoPage";
	}

}
