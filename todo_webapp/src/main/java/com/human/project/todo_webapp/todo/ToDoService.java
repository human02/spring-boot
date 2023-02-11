package com.human.project.todo_webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	public static int idCount = 0;

	static {
		todos.add(new Todo(++idCount, "test", "Get AWS Certified", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++idCount, "test", "Learn Rust", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++idCount, "test", "Learn Kafka", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUser(String user) {
//		System.out.println("CHECK IT "+LocalDate.now().plusYears(1));
		return todos;
	}

	public void addToDo(String user, String description, LocalDate targetdate, boolean done) {
		todos.add(new Todo(++idCount, user, description, targetdate, done));
	}

	public void deleteById(int id) {
		// Predicate is a condition
		// our case --> if todo.getId() == id then remove that todo
		// Simplest way to use lambda function = todo -> todo.getId() == id
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		// List<ToDo> toRemove = this.findByUser(id);
		todos.removeIf(predicate);
	}
	
	public void update(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
} 