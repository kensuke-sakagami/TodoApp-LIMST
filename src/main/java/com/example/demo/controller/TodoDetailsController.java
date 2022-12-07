package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.ChangeTodoDetailForm;
import com.example.demo.domain.model.TodoDetails;
import com.example.demo.domain.repository.TodoDetailsDao;

@Controller
public class TodoDetailsController {
	@Autowired
	TodoDetailsDao dao;
	@Autowired
	TodoListController todoListController;
	@GetMapping("/{id}")
	public String getTodoDetails(@ModelAttribute ChangeTodoDetailForm form, Model model, @PathVariable("id") int id) {
		TodoDetails todoDetailsList = dao.selectOne(id);

		form.setTitle(todoDetailsList.getTitle());
		form.setDate(todoDetailsList.getTimeLimit());
		form.setDone(todoDetailsList.isDone());
		model.addAttribute("changeTodoDetailForm", form);
		return "Todo/TodoDetail";
	}

	@PostMapping("/{id}")
	public String postTodoDetails(@ModelAttribute @Validated ChangeTodoDetailForm form, Model model, @PathVariable("id") int id) {

		TodoDetails todoDetails = new TodoDetails();

		todoDetails.setTitle(form.getTitle());
		todoDetails.setDone(form.isDone());
		todoDetails.setTimeLimit(form.getDate());
		todoDetails.setId(id);
		dao.updateOne(todoDetails);
		return "redirect:/";
	}
}
