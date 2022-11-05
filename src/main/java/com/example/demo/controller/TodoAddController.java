package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.TodoForm;
import com.example.demo.domain.model.TodoDetails;
import com.example.demo.domain.repository.TodoDetailsDao;

@Controller
public class TodoAddController {
	@Autowired
	TodoDetailsDao dao;

	@GetMapping("/add")
	public String getTodoAdd(Model model, @ModelAttribute TodoForm form) {
		return "Todo/TodoAdd";
	}

	@PostMapping("/add")
	public String postTodoAdd(Model model, @ModelAttribute @Validated TodoForm form, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return getTodoAdd(model, form);
		}

		TodoDetails todoDetails = new TodoDetails();
		todoDetails.setTitle(form.getTitle());
		todoDetails.setIsDone(form.getIsDone());
		todoDetails.setTimeLimit(form.getDate());

		dao.insertOne(todoDetails);
		return "redirect:/";
	}
}
