package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.domain.model.Todo;

public interface TodoDetailsDao {
	// TodoDetailsテーブルの全データを取得.
	public List<Todo> TrueSelectMany() throws DataAccessException;

	public List<Todo> FalseSelectMany() throws DataAccessException;

	public Todo selectOne(int id) throws DataAccessException;

	public int updateOne(Todo todoDetails) throws DataAccessException;

}
