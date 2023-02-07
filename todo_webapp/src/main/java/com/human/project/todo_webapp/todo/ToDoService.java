package com.human.project.todo_webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	private static List<ToDo> todos = new ArrayList<ToDo>();
	
	static {
		todos.add(new ToDo(1, "Aarav", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(2, "Aarav", "Learn Rust", LocalDate.now().plusYears(2), false));
		todos.add(new ToDo(3, "Aarav", "Learn Kafka", LocalDate.now().plusYears(3), false));
	}

	public List<ToDo> findByUser(String user) {
		return todos;
	}
}