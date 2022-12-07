package com.example.demo.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.TodoDetails;
import com.example.demo.domain.repository.TodoDetailsDao;

@Repository
public class TodoDetailsJdbcImpl implements TodoDetailsDao{
	@Autowired
	JdbcTemplate jdbc;


	// TodoDetailsテーブルの全データを取得.
	@Override
	public List<TodoDetails> TrueSelectMany() throws DataAccessException {
		//TodoDetailsテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM todo_details WHERE is_done = TRUE"); 
		//結果返却用の変数List 
		List<TodoDetails> todoDetailsList = new ArrayList<>();
		//取得したデータを結果返却用のListに格納していく
		for(Map<String,Object> map:getList) {
			//TodoDetailsインスタンスの作成
			TodoDetails todoDetails = new TodoDetails();
			//TodoDetailsインスタンスに取得したデータをセット
			todoDetails.setId((int)map.get("id"));
			todoDetails.setTitle((String)map.get("title"));
			todoDetails.setTimeLimit(((java.sql.Date)map.get("time_limit")).toLocalDate());

			todoDetailsList.add(todoDetails);
		}
		return todoDetailsList;
	}

	@Override
	public List<TodoDetails> FalseSelectMany() throws DataAccessException {
		//TodoDetailsテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM todo_details WHERE is_done = FALSE"); 
		//結果返却用の変数List 
		List<TodoDetails> todoDetailsList = new ArrayList<>();
		//取得したデータを結果返却用のListに格納していく
		for(Map<String,Object> map:getList) {
			//TodoDetailsインスタンスの作成
			TodoDetails todoDetails = new TodoDetails();
			//TodoDetailsインスタンスに取得したデータをセット
			todoDetails.setId((int)map.get("id"));
			todoDetails.setTitle((String)map.get("title"));
			todoDetails.setTimeLimit(((java.sql.Date)map.get("time_limit")).toLocalDate());

			todoDetailsList.add(todoDetails);
		}
		return todoDetailsList;
	}

	// TodoDetailsテーブルの全データを取得.
	@Override
	public TodoDetails selectOne(int id) throws DataAccessException {
		//TodoDetailsテーブルのデータを全件取得
		Map<String, Object> map= jdbc.queryForMap("SELECT * FROM todo_details WHERE id = ?", id); 

		//TodoDetailsインスタンスの作成
		TodoDetails todoDetails = new TodoDetails();
		//TodoDetailsインスタンスに取得したデータをセット
		todoDetails.setId((int)map.get("id"));
		todoDetails.setTitle((String)map.get("title"));
		todoDetails.setTimeLimit(((java.sql.Date)map.get("time_limit")).toLocalDate());
		todoDetails.setDone((boolean)map.get("is_done"));
	
		return todoDetails;
	}

	@Override
	public int updateOne(TodoDetails todoDetails)throws DataAccessException {
		int rowNumber = jdbc.update("UPDATE todo_details"
				+ " SET"
				+ " title = ?,"
				+ " is_done = ?,"
				+ " time_limit = ?"
				+ " WHERE id = ?"
				,todoDetails.getTitle()
				,todoDetails.isDone()			
				,todoDetails.getTimeLimit()
				,todoDetails.getId());

		return rowNumber;
	}

	@Override
	public int insertOne(TodoDetails todoDetails) throws DataAccessException {
		int rowNumber = jdbc.update("INSERT INTO todo_details(title,"
				+ " is_done,"
				+ " time_limit)"
				+ " VALUES(?,?,?)",
				todoDetails.getTitle(),
				todoDetails.isDone(),
				todoDetails.getTimeLimit());

		return rowNumber;
	}

	@Override
	public int deleteAll() throws DataAccessException {
		int rowNumber = jdbc.update("DELETE FROM todo_details"
				+ " WHERE is_done = true");
		return rowNumber;
	}

}
