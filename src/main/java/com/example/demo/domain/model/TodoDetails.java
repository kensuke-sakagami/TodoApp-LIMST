package com.example.demo.domain.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TodoDetails {
	private int id; 
	private String title;
	private boolean isDone;
	private LocalDate timeLimit;
}
