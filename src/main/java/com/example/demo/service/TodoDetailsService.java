package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Todo;
import com.example.demo.domain.repository.TodoDetailsDao;

@Service
public class TodoDetailsService {
	@Autowired
	TodoDetailsDao dao;
	
	public List<Todo> TrueSelectMany(){
		return dao.TrueSelectMany();
	}
	
	public List<Todo> FalseSelectMany(){
		return dao.FalseSelectMany();
	}
}
