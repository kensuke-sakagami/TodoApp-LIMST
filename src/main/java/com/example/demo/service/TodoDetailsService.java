package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.TodoDetails;
import com.example.demo.domain.repository.TodoDetailsDao;

@Service
public class TodoDetailsService {
	@Autowired
	TodoDetailsDao dao;
	
	public List<TodoDetails> TrueSelectMany(){
		return dao.TrueSelectMany();
	}
	
	public List<TodoDetails> FalseSelectMany(){
		return dao.FalseSelectMany();
	}
}
