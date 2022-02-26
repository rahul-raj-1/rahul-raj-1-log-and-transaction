/*
 * package com.example.log.config;
 * 
 * import java.sql.Connection; import java.sql.SQLException;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.core.env.Environment;
 * 
 * import com.zaxxer.hikari.HikariConfig; import
 * com.zaxxer.hikari.HikariDataSource;
 * 
 * 
 * 
 * import java.sql.Connection; import java.sql.SQLException;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.core.env.Environment;
 * 
 * import com.zaxxer.hikari.HikariConfig;
 * 
 * 
 * public class ConnectionFactory {
 * 
 * private static interface Singleton { final ConnectionFactory INSTANCE = new
 * ConnectionFactory(); }
 * 
 * private final DataSource dataSource;
 * 
 * @Autowired private Environment environment;
 * 
 * 
 * private ConnectionFactory() { HikariConfig config = new HikariConfig();
 * config.setJdbcUrl("jdbc:oracle:thin:@//localhost:1521/orcl");
 * config.setUsername("system"); config.setPassword("password");
 * config.setMaximumPoolSize(2); config.setMinimumIdle(0);
 * config.setIdleTimeout(60000); dataSource = new HikariDataSource(config);
 * System.out.println( " in here");
 * 
 * }
 * 
 * public static Connection getDatabaseConnection() throws SQLException {
 * 
 * Connection c = Singleton.INSTANCE.dataSource.getConnection(); return c; } }
 */