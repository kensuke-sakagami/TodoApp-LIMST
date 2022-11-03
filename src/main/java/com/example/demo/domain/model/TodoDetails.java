package com.example.demo.domain.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TodoDetails {
	private int id; 
	private String title;
	private String isDone;
	private LocalDate timeLimit;
	private boolean blIsDone;
}
