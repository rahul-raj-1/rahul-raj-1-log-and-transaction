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

import com.example.log.exception.SecondInsertException;


@Service
public class RepositoryTwo {
	
	
	private final String INSERT_SQL = "INSERT INTO APP_LOG(APP_NAME) values(?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public String insertSecondAuthor (String id)
	{
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, "SECOND_AUTHOR_RAJ");
				return ps;
			}
		});
		return null;
		
	}
	
	public String insertSecond(String id ) 
	{
		
		System.out.println("---- Calling insertSecond ---- ");


		 insertSecondAuthor(id);
		 
		 String s="1";

		 if(s.equals("1")) {
			 throw new RuntimeException("DummyException: this should cause rollback !");
			
			  }
		
		return null;
		 
	}
	
	@Transactional(propagation =  Propagation.REQUIRES_NEW ,rollbackFor = SecondInsertException.class)
	public String insertSecondNewTrans(String id ) 
	{

		System.out.println("---- Calling insertSecondNewTrans ---- ");
		 insertSecondAuthor(id);
		 
		 String status = "1";
			if (status.equals("1")) {

				throw new SecondInsertException("SecondInsertException : rollback second exception !");

			}

	
		return null;
		 
	}

}
