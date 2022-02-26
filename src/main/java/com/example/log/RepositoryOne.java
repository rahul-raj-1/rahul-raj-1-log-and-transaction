package com.example.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.log.exception.FirstInsertException;

@Service
public class RepositoryOne {

	private final String INSERT_SQL = "INSERT INTO APP_LOG(APP_NAME) values(?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String insertFirstAuthor(String id) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, "FIRST_AUTHOR_RAHUL");
				return ps;
			}
		});
		return null;

	}

      public String insertFirstNewTrans(String id) {

		System.out.println("---- Calling insertFirstNewTrans ---- ");
		insertFirstAuthor(id);
		
		String status = "0";
		if (status.equals("1")) {
		

			throw new FirstInsertException("FirstInsertException : rollback first exception !");

		}
		
		return null;

	}

}
