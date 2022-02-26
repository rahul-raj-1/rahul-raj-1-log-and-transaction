/*
 * package com.example.log.config; import javax.annotation.PostConstruct;
 * 
 * import org.apache.logging.log4j.Level; import
 * org.apache.logging.log4j.LogManager; import
 * org.apache.logging.log4j.ThreadContext; import
 * org.apache.logging.log4j.core.Logger; import
 * org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig; import
 * org.apache.logging.log4j.core.appender.db.jdbc.JdbcAppender; import
 * org.apache.logging.log4j.core.filter.ThresholdFilter; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.env.Environment;
 * 
 * @Configuration public class LogConfig {
 * 
 * @Autowired private Environment env;
 * 
 * private final String appName="APP_1";
 * 
 * 
 * 
 * @PostConstruct public void onStartUp() {
 * 
 * LogDatabaseConnectionSource connectionSource = new
 * LogDatabaseConnectionSource("","","");
 * 
 * 
 * ColumnConfig[] columnConfigs = new ColumnConfig[5]; columnConfigs[0] =
 * ColumnConfig.newBuilder() .setName("SERVICE_NAME") .setPattern("ACCESS")
 * .build(); columnConfigs[1] =
 * ColumnConfig.newBuilder().setName("LOG_DATE").setEventTimestamp(true).build()
 * ; columnConfigs[2] =
 * ColumnConfig.newBuilder().setName("LOG_LEVEL").setPattern("%level").
 * setUnicode(false).build(); columnConfigs[3] =
 * ColumnConfig.newBuilder().setName("MESSAGE").setPattern("%message").
 * setUnicode(false).build(); columnConfigs[4] =
 * ColumnConfig.newBuilder().setName("CLASS_NAME").setPattern("%c{10}").
 * setUnicode(true).build();
 * 
 * ThresholdFilter filter = ThresholdFilter.createFilter(Level.ERROR, null,
 * null);
 * 
 * 
 * JdbcAppender appender = JdbcAppender.newBuilder()
 * .setColumnConfigs(columnConfigs) .setConnectionSource(connectionSource)
 * .setTableName("TBL_ERROR_LOG") .setName("DbAppender") //
 * .withIgnoreExceptions(false). .setFilter(filter) .build();
 * 
 * 
 * // start the appender, and this is it... appender.start(); ((Logger)
 * LogManager.getRootLogger()).addAppender(appender); } }
 */