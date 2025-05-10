package com.edutech.plataforma_educativa.micro2cursos.config;

import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.edutech.plataforma_educativa.micro2cursos.repository",
    entityManagerFactoryRef = "micro2EntityManagerFactory",
    transactionManagerRef = "micro2TransactionManager"
)
@EntityScan(basePackages = "com.edutech.plataforma_educativa.micro2cursos.model")
public class Micro2DataSourceConfig {

    @Bean(name = "micro2DataSource")
    public DataSource micro1DataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/micro2_cursos");
        dataSource.setUsername("root");
        dataSource.setPassword("Lautaro2018!");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean(name = "micro2JpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.micro2")
    public JpaProperties micro2JpaProperties() {
        return new JpaProperties();
    }

    @Bean(name = "micro2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean micro2EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("micro2DataSource") DataSource dataSource,
            @Qualifier("micro2JpaProperties") JpaProperties jpaProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.edutech.plataforma_educativa.micro2cursos.model")
                .persistenceUnit("micro2")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = "micro2TransactionManager")
    public PlatformTransactionManager micro2TransactionManager(
            @Qualifier("micro2EntityManagerFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
