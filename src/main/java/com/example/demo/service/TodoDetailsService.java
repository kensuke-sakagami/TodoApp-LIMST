package com.example.demo.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.TodoDetails;
import com.example.demo.domain.repository.TodoDetailsDao;

@Service
public class TodoDetailsService {
	@Autowired
	TodoDetailsDao dao;

	@Autowired
	MessageSource messageSource;

	public List<TodoDetails> TrueSelectMany(){
		return dao.TrueSelectMany();
	}

	public List<TodoDetails> FalseSelectMany(){
		return dao.FalseSelectMany();
	}

	public Map<String, Integer>getMessageMap(){
		Map<String, Integer> messageMap = new LinkedHashMap<>();
		String titleMessage = messageSource.getMessage("title", null, Locale.JAPAN);
		String dateMessage = messageSource.getMessage("date", null, Locale.JAPAN);

		messageMap.put(titleMessage, 1);
		messageMap.put(dateMessage, 2);
		return messageMap;
	}
}
