package com.fst.asustech.configure;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "stockEntityManagerFactory",
        transactionManagerRef = "stockTransactionManager",
        basePackages = {"com.fst.asustech.dao.g.stock"}
)
public class ConfigureGStockDB {

    @Bean(name = "stockDataSource")
    @ConfigurationProperties(prefix = "db2.datasource")
    public DataSource DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "stockEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    barEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("stockDataSource") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("com.fst.asustech.entity.g.stock")
                        .persistenceUnit("g_stock")
                        .build();
    }

    @Bean(name = "stockTransactionManager")
    public PlatformTransactionManager stockTransactionManager(
            @Qualifier("stockEntityManagerFactory") EntityManagerFactory
            	stockEntityManagerFactory
    ) {
        return new JpaTransactionManager(stockEntityManagerFactory);
    }
}
