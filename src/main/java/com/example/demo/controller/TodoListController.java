package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.TodoDetails;
import com.example.demo.domain.repository.TodoDetailsDao;


@Controller
public class TodoListController {
	@Autowired
	TodoDetailsDao dao;
	//ログイン用のGETコントローラー
	@GetMapping("/")
	public String getTodoList(Model model) {
		List<TodoDetails> trueTodoDetailsList = dao.TrueSelectMany();
		List<TodoDetails> falseTodoDetailsList = dao.FalseSelectMany();

		model.addAttribute("trueTodoDetailsList", trueTodoDetailsList);
		model.addAttribute("falseTodoDetailsList", falseTodoDetailsList);
		//TodoList.htmlに遷移
		return "Todo/TodoList";
	}
	
	@PostMapping("delete")
	public String postDeleteTodoList(Model model) {
		dao.deleteAll();
		return "redirect:/";
	}
}
