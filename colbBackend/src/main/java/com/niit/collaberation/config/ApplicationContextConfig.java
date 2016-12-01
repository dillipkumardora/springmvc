package com.niit.collaberation.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaberation.dao.FriendDAO;
import com.niit.collaberation.dao.UserDAO;
import com.niit.collaberation.daoImpl.FriendDAOImpl;
import com.niit.collaberation.daoImpl.UserDAOImpl;
import com.niit.collaberation.model.User;

@Configuration
@ComponentScan("com.niit.collaboration")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("colb1");
		dataSource.setPassword("root");
		System.out.println("db");
		
		return dataSource;
	}
	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		System.out.println("prop");
		return properties;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(User.class);
    	System.out.println("session");
    	return sessionBuilder.buildSessionFactory();
    }
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);
System.out.println("tran");
		return transactionManager;
	}
	
	
	@Autowired
    @Bean(name = "UserDAO")
    public UserDAO getUserDAO(SessionFactory sessionFactory) 
	{
		System.out.println("userdao");
    	return new UserDAOImpl(sessionFactory);
    }

	
	@Autowired
    @Bean(name = "FriendDAO")
    public FriendDAO getFriendDAO(SessionFactory sessionFactory) 
	{
		System.out.println("frienddao");
    	return new FriendDAOImpl(sessionFactory);
    }

	
	
}
