package com.example.demo.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.TodoDetails;
import com.example.demo.domain.model.TodoForm;
import com.example.demo.domain.repository.TodoDetailsDao;

@Controller
public class TodoDetailsController {
	@Autowired
	TodoDetailsDao dao;
	@Autowired
	TodoListController todoListController;
	@GetMapping("/{id}")
	public String getTodoDetails(@ModelAttribute TodoForm form, Model model, @PathVariable("id") int id) {
		TodoDetails todoDetailsList = dao.selectOne(id);

		form.setTitle(todoDetailsList.getTitle());
		form.setDate(todoDetailsList.getTimeLimit());
		form.setDone(todoDetailsList.isDone());
		model.addAttribute("changeTodoDetailForm", form);
		return "Todo/TodoDetail";
	}

	@PostMapping("/{id}")
	public String postTodoDetails(Model model, @ModelAttribute @Validated TodoForm form, BindingResult bindingResult, @PathVariable("id") int id) {
		if(bindingResult.hasErrors()) {
			return getTodoDetails(form, model, id);
		}
		
		TodoDetails todoDetails = new TodoDetails();

		todoDetails.setTitle(form.getTitle());
		todoDetails.setDone(form.isDone());
		todoDetails.setTimeLimit(form.getDate());
		todoDetails.setId(id);
		dao.updateOne(todoDetails);
		return "redirect:/";
	}

	@GetMapping("/add")
	public String getTodoAdd(Model model, @ModelAttribute TodoForm form) {
		Date date = new Date();
		LocalDateTime localDateTime = new Timestamp(date.getTime()).toLocalDateTime();
		LocalDate localDate = localDateTime.toLocalDate();
		form.setDate(localDate);
		
		return "Todo/TodoAdd";
	}

	@PostMapping("/add")
	public String postTodoAdd(Model model, @ModelAttribute @Validated TodoForm form, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return getTodoAdd(model, form);
		}

		TodoDetails todoDetails = new TodoDetails();
		todoDetails.setTitle(form.getTitle());
		todoDetails.setDone(form.isDone());
		todoDetails.setTimeLimit(form.getDate());

		dao.insertOne(todoDetails);
		return "redirect:/";
	}
}
