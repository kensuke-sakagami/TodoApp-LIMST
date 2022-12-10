package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.model.Todo;
import com.example.demo.domain.repository.TodoDetailsDao;


@Controller
public class TodoListController {
	@Autowired
	TodoDetailsDao dao;
	//ログイン用のGETコントローラー
	@GetMapping("/")
	public String getTodoList(Model model) {
		List<Todo> trueTodoDetailsList = dao.TrueSelectMany();
		List<Todo> falseTodoDetailsList = dao.FalseSelectMany();

		model.addAttribute("trueTodoDetailsList", trueTodoDetailsList);
		model.addAttribute("falseTodoDetailsList", falseTodoDetailsList);
		//TodoList.htmlに遷移
		return "Todo/TodoList";
	}
}
