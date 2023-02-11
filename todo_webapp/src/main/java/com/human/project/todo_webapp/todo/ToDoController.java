package com.human.project.todo_webapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
		List<Todo> todos = todoService.findByUser("test");
		model.addAttribute("todos", todos);

		return "todoPage";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewToDoPage(ModelMap model) {
		String username = (String) model.getAttribute("name");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewToDo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}
		String username = (String) model.getAttribute("name");
		todoService.addToDo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:list-todos"; // redirect: redirects to a previous request mapping as mentioned in our case
	}
}
