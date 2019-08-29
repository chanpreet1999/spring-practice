package com.luv2code.springsecuritydemo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecuritydemo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoConfig {
	
	@Autowired
	private Environment env;
	
	private Logger logger=Logger.getLogger(getClass().getName());
	
	//define a bean for internal view resolver
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DataSource securityDataSource(){
		
		//create a connection pool
		ComboPooledDataSource securityDataSource
						=new ComboPooledDataSource();
		
		//set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		//log the connection props
		logger.info(">>>>jdbc.url:"+env.getProperty("jdbc.url"));
		logger.info(">>>>>jdbc.user"+env.getProperty("jdbc.user"));
		
		//set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool props
		securityDataSource.setInitialPoolSize(
							changeToInt("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(
				changeToInt("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(
				changeToInt("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(
				changeToInt("connection.pool.maxIdleTime"));
		return securityDataSource;
	}
	
	//helper function to change env property to int
	public int changeToInt(String propName){
		String propertyVal=env.getProperty(propName);
		
		int intPropVal=Integer.parseInt(propertyVal);
		
		return intPropVal;
	}
	
}
