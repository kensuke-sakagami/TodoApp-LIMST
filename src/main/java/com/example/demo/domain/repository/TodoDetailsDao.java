package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.domain.model.TodoDetails;

public interface TodoDetailsDao {
	// TodoDetailsテーブルの全データを取得.
	public List<TodoDetails> TrueSelectMany() throws DataAccessException;

	public List<TodoDetails> FalseSelectMany() throws DataAccessException;

	public TodoDetails selectOne(int id) throws DataAccessException;

	public int updateOne(TodoDetails todoDetails) throws DataAccessException;
	
	public int insertOne(TodoDetails todoDetails) throws DataAccessException;
	
	public int deleteAll() throws DataAccessException;
}
