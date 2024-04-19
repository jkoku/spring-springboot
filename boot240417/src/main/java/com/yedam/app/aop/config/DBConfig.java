package com.yedam.app.aop.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	
	// private final DataSource datasource;
	
	@Bean
	public TransactionManager transactionManager(DataSource datasource) { // transationmanager가 가장상위 PlatformTran 등등 각각기능따라 사용해도됨. 
		return new DataSourceTransactionManager(datasource); 
	}
	
}


// 3버전은 이 방식으로 등록해서 사용.
// 빈을 등록해야한다면 이런 방법으로 등록할 것. 