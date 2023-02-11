package com.human.project.todo_webapp.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

// its a bean to store all the ToDo details,
// typically we need to store it in a database.
// now we will do step by step: static list and later h2 database
public class Todo {

	public Todo(int id, String username, String description, LocalDate targetdate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetdate = targetdate;
		this.done = done;
	}

	private int id;
	private String username;
	@Size(min=10, message="Add atleast 10 characters")
	private String description;
	private LocalDate targetdate;
	private boolean done;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetdate() {
		return targetdate;
	}

	public void setTargetdate(LocalDate targetdate) {
		this.targetdate = targetdate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", username=" + username + ", description=" + description + ", targetdate="
				+ targetdate + ", done=" + done + "]";
	}

}
