package com.human.project.todo_webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	private static List<ToDo> todos = new ArrayList<ToDo>();
	 public static int idCount=0;
	
	static {
		todos.add(new ToDo(++idCount, "test", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(++idCount, "test", "Learn Rust", LocalDate.now().plusYears(2), false));
		todos.add(new ToDo(++idCount, "test", "Learn Kafka", LocalDate.now().plusYears(3), false));
	}

	public List<ToDo> findByUser(String user) {
//		System.out.println("CHECK IT "+LocalDate.now().plusYears(1));
		return todos;
	}
	
	public void addToDo(String user,String description,LocalDate targetdate,boolean done) {
		todos.add(new ToDo(++idCount,user,description,targetdate,done));
	}
}