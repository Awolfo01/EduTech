package com.edutech.plataforma_educativa.micro1usuarios.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.edutech.plataforma_educativa.micro1usuarios.repository",
    entityManagerFactoryRef = "micro1EntityManagerFactory",
    transactionManagerRef = "micro1TransactionManager"
)
@EntityScan(basePackages = "com.edutech.plataforma_educativa.micro1usuarios.model")
public class Micro1DataSourceConfig {

    @Bean(name = "micro1DataSource")
    public DataSource micro1DataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/micro1_usuarios");
        dataSource.setUsername("root");
        dataSource.setPassword("Lautaro2018!");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean(name = "micro1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean micro1EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("micro1DataSource") DataSource dataSource,
            @Qualifier("micro1JpaProperties") JpaProperties jpaProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.edutech.plataforma_educativa.micro1usuarios.model")
                .persistenceUnit("micro1")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = "micro1TransactionManager")
    public PlatformTransactionManager micro1TransactionManager(
            @Qualifier("micro1EntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean(name = "micro1JpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.micro1")
    public JpaProperties micro1JpaProperties() {
        return new JpaProperties();
    }
}

