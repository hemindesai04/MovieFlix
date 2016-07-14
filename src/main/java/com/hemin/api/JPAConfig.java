package com.hemin.api;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	
	//for entity manager factory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(datasource());
		emf.setPackagesToScan("com.hemin.api.entities");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaProperties(jpaProperties());
		return emf;
	}

	//method which defines connection to database
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/movieflixdb?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	//method for transaction management (declaring here will allow you to annotate the service/repository 
	//layer classes and carry out multiple queries using transaction management)
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager trnscManager = new JpaTransactionManager(emf);
		return trnscManager;
	}
	
	//method which returns properties of jpa
	public Properties jpaProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");  // represents the hibernate implementation
		props.setProperty("hibernate.hbm2ddl.auto", "create-drop"); // represents whether the db schema will be create-drop or validate
	//	props.setProperty("hibernate.show_sql", "true");	// to check the queries implementated by hibernate
		props.setProperty("hibernate.format_sql", "true");	
		return props;
	}
}
