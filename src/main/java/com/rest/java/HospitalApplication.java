package com.rest.java;

import org.apache.tomcat.jdbc.pool.PoolExhaustedException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	public HibernateJpaSessionFactoryBean factory() {
		return new HibernateJpaSessionFactoryBean();
	} 

	protected boolean isAcquireTimeoutException(Exception e) {
	    return e instanceof PoolExhaustedException;
	}
	 

}
