package com.abhijeet.springbootrest.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;

@Configuration
public class DataSourceConfig {
	/*public static final String JNDI_NAME = "jdbc/databaseName";

	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		return dataSourceLookup.getDataSource(JNDI_NAME);
	}

	@Bean
	public AnnotationMBeanExporter annotationMBeanExporter() {
		AnnotationMBeanExporter annotationMBeanExporter = new AnnotationMBeanExporter();
		annotationMBeanExporter.setExcludedBeans("dataSource");
		return annotationMBeanExporter;
	}*/
}