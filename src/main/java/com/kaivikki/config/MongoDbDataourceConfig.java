/*
 * package com.kaivikki.config;
 * 
 * import javax.persistence.EntityManagerFactory; import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.boot.autoconfigure.jdbc.DataSourceProperties; import
 * org.springframework.boot.context.properties.ConfigurationProperties; import
 * org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.orm.jpa.JpaTransactionManager; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.transaction.PlatformTransactionManager; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * import com.zaxxer.hikari.HikariDataSource;
 * 
 * @Configuration
 * 
 * @EnableTransactionManagement
 * 
 * @EnableJpaRepositories(entityManagerFactoryRef = "mongoEntityManagerFactory",
 * transactionManagerRef = "mongoTransactionManager", basePackages = {
 * "com.kaivikki.repositories" }) public class MongoDbDataourceConfig {
 * 
 * @Bean(name = "mongoDataSourceProperties")
 * 
 * @ConfigurationProperties("spring.data.mongodb") public DataSourceProperties
 * mongoDataSourceProperties() { return new DataSourceProperties(); }
 * 
 * @Bean(name = "mongoDataSource") public DataSource mongoDataSource() { return
 * mongoDataSourceProperties().initializeDataSourceBuilder().type(
 * HikariDataSource.class).build(); }
 * 
 * @Bean(name = "mongoEntityManagerFactory") public
 * LocalContainerEntityManagerFactoryBean mongoEntityManagerFactory(
 * EntityManagerFactoryBuilder entityManagerFactoryBuilder) { return
 * entityManagerFactoryBuilder.dataSource(mongoDataSource()).packages(
 * "com.kaivikki.documents").build(); }
 * 
 * @Bean(name = "mongoTransactionManager") public PlatformTransactionManager
 * pgTransactionManager(
 * 
 * @Qualifier("mongoEntityManagerFactory") EntityManagerFactory
 * mongoEntityManagerFactory) { return new
 * JpaTransactionManager(mongoEntityManagerFactory); } }
 */