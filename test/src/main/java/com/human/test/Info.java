package com.human.test;

public class Info {
	private String name;
	private String link;
	
	public Info(String name, String link) {
		super();
		this.name = name;
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}

	@Override
	public String toString() {
		return "Info [name=" + name + ", link=" + link + "]";
	}

}
