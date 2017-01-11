package com.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.repo", entityManagerFactoryRef = "primaryEntityManagerFactory", transactionManagerRef = "primaryTransactionManager")
@EnableTransactionManagement
@PropertySource("classpath:primary-datasource.properties")
public class PrimaryDataSourceConfig
{
 @Bean
 @ConfigurationProperties(prefix = "primary.datasource")
 @Primary
 public DataSource primaryDataSource()
 {
   return DataSourceBuilder.create().build();
 }

 @Bean
 @Primary
 public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(final EntityManagerFactoryBuilder builder)
 {
   return builder
       .dataSource(primaryDataSource())
       .packages("com.example.entity")
       .persistenceUnit("primaryPersistenceUnit")
       .build();
 }

 @Bean
 @Primary
 public JpaTransactionManager primaryTransactionManager(@Qualifier("primaryEntityManagerFactory") final EntityManagerFactory factory)
 {
   return new JpaTransactionManager(factory);
 }
}