package com.example.log.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class OracleDBConfiguration {

	@Bean
	public DataSource dataSource() throws SQLException {
		HikariConfig dbConfig = new HikariConfig();
		dbConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		dbConfig.setUsername("system");
		dbConfig.setPassword("password");
		dbConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		dbConfig.setMaximumPoolSize(2);
		dbConfig.setMinimumIdle(0);
		dbConfig.setAutoCommit(false);

		dbConfig.setIdleTimeout(30000);

		HikariDataSource ds = new HikariDataSource(dbConfig);
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws SQLException {
		return new JdbcTemplate(dataSource());

	}

}
