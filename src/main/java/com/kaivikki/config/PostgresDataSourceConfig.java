package com.kaivikki.config;



import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "pgEntityManagerFactory", 
transactionManagerRef = "pgTransactionManager",basePackages = {"com.kaivikki.repositories"})
public class PostgresDataSourceConfig {

	@Primary
	@Bean(name="postGresDataSourceProperties")
	@ConfigurationProperties("spring.datasource-pg")
	 public DataSourceProperties postGresDataSourceProperties() {
		  return new DataSourceProperties();
	 }
	
	@Primary
	@Bean(name="pgDataSource")
	public DataSource pgDataSource() {
		return postGresDataSourceProperties().initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
	}
	 
	@Primary
	@Bean(name="pgEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean pgEntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
		Map<String, Object> pgJpaProperties = new HashMap<>();
		// pgJpaProperties.put("hibernate.format_sql", true);
		return entityManagerFactoryBuilder.dataSource(pgDataSource())
				.packages("com.kaivikki.*")
				.persistenceUnit("pgDataSource").properties(pgJpaProperties)
				.build();
	}
	
	@Primary
	@Bean(name="pgTransactionManager")
	public PlatformTransactionManager pgTransactionManager(@Qualifier("pgEntityManagerFactory") EntityManagerFactory pgEntityManagerFactory) {
		return new JpaTransactionManager(pgEntityManagerFactory);
	}
	
}
