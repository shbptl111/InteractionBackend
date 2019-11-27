package com.coll.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.model.ApplyingJob;
import com.coll.model.Blog;
import com.coll.model.BlogComment;
import com.coll.model.Forum;
import com.coll.model.ForumComment;
import com.coll.model.Friend;
import com.coll.model.Job;
import com.coll.model.ProfilePicture;
import com.coll.model.UserDetail;

@Configuration
@ComponentScan("com.coll")
@EnableTransactionManagement
public class DBConfig {
	
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("mycoll");
		dataSource.setPassword("pass123");
		System.out.println("DataSource object created");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.hbmddl2.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		// hibernateProp.put("hibernate.current_session_context_class", "thread"); // Remove this if there is any problem with Hibernate session
		// hibernateProp.put("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults", "false");
	
		LocalSessionFactoryBuilder factoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		factoryBuilder.addProperties(hibernateProp);
		
		factoryBuilder.addAnnotatedClass(Blog.class);
		factoryBuilder.addAnnotatedClass(BlogComment.class);
		factoryBuilder.addAnnotatedClass(UserDetail.class);
		factoryBuilder.addAnnotatedClass(Job.class);
		factoryBuilder.addAnnotatedClass(Forum.class);
		factoryBuilder.addAnnotatedClass(ForumComment.class);
		factoryBuilder.addAnnotatedClass(Friend.class);
		factoryBuilder.addAnnotatedClass(ApplyingJob.class);
		factoryBuilder.addAnnotatedClass(ProfilePicture.class);
		
		SessionFactory sessionFactory = factoryBuilder.buildSessionFactory();
		System.out.println("SessionFactory object created");
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		System.out.println("TransactionManager object created");
		return new HibernateTransactionManager(sessionFactory);
	}
	
}