package com.human.project.todo_webapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {

	public ToDoController(ToDoService todoService) {
		super();
		this.todoService = todoService;
	}

	private ToDoService todoService;

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<ToDo> todos = todoService.findByUser("test");
		model.addAttribute("todos", todos);

		return "todoPage";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewToDoPage() {

		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewToDo(@RequestParam String description, ModelMap model) {
		String username = (String)model.getAttribute("name");
		todoService.addToDo(username, description, LocalDate.now().plusYears(1), false);
		return "redirect:list-todos"; // redirect: redirects to a previous request mapping as mentioned in our case
	}
}
