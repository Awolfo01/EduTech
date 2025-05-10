package com.edutech.plataforma_educativa.micro3expcliente.config;

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
    basePackages = "com.edutech.plataforma_educativa.micro3expcliente.repository",
    entityManagerFactoryRef = "micro3EntityManagerFactory",
    transactionManagerRef = "micro3TransactionManager"
)
@EntityScan(basePackages = "com.edutech.plataforma_educativa.micro3expcliente.model")
public class Micro3DataSourceConfig {

    @Bean(name = "micro3DataSource")
    public DataSource micro3DataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/micro3_experiencia");
    dataSource.setUsername("root");
    dataSource.setPassword("Lautaro2018!");
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    return dataSource;
}

    @Bean(name = "micro3JpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.micro3")
    public JpaProperties micro3JpaProperties() {
        return new JpaProperties();
    }

    @Bean(name = "micro3EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean micro3EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("micro3DataSource") DataSource dataSource,
            @Qualifier("micro3JpaProperties") JpaProperties jpaProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.edutech.plataforma_educativa.micro3expcliente.model")
                .persistenceUnit("micro3")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = "micro3TransactionManager")
    public PlatformTransactionManager micro3TransactionManager(
            @Qualifier("micro3EntityManagerFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
