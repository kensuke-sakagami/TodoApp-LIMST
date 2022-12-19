package com.example.demo.domain.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Todo {
	private int id; 
	private String title;
	private LocalDate timeLimit;
	private Boolean isDone;
}
