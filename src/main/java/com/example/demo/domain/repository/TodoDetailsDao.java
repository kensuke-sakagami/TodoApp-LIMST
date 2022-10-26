package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.domain.model.TodoDetails;

public interface TodoDetailsDao {
	// TodoDetailsテーブルの全データを取得.
	public List<TodoDetails> TrueSelectMany() throws DataAccessException;

	public List<TodoDetails> FalseSelectMany() throws DataAccessException;

}
