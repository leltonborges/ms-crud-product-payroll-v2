package org.ms.payroll.payroll.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

//@Configuration
//@EnableJpaRepositories(
//        basePackages = "org.ms.payroll.payroll.repositories.product",
//        entityManagerFactoryRef = "productManager"
//)
public class ProductDBConfig {

    @Bean(name = "productDB")
    @ConfigurationProperties(prefix = "product.datasource")
    public DataSource productDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("productManager")
    public LocalContainerEntityManagerFactoryBean productEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("productDB") DataSource source
    ){
        return builder
                .dataSource(source)
                .packages("org.ms.payroll.payroll.entities.product")
                .build();
    }
}
