package com.example.restservice;

public class Base {
    private final long id;
    private final String content;
    private final String color;

	public Base(long id, String content, String color) {
		this.id = id;
    this.content = content;
    this.color = color;
	}
	public long getId() {
		return id;
  }
  
	public String getColor() {
		return color;
	}

	public String getContent() {
		return content;
	}
}