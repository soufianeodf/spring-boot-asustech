package com.fst.asustech.configure;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "venteEntityManagerFactory",
        transactionManagerRef = "venteTransactionManager",
        basePackages = {"com.fst.asustech.dao.g.vente"}
)
public class ConfigureGVenteDB {
	
    @Primary
    @Bean(name = "venteDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource venteDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "venteEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("venteDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.fst.asustech.entity.g.vente")
                .persistenceUnit("g_vente")
                .build();
    }

    @Primary
    @Bean(name = "venteTransactionManager")
    public PlatformTransactionManager venteTransactionManager(
            @Qualifier("venteEntityManagerFactory") EntityManagerFactory
            	venteEntityManagerFactory
    ) {
        return new JpaTransactionManager(venteEntityManagerFactory);
    }
}
