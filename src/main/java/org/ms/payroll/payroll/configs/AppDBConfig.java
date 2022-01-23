package org.ms.payroll.payroll.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@Configuration
//@EnableJpaRepositories(
//        basePackages = "org.ms.payroll.payroll.repositories.payroll",
//        entityManagerFactoryRef = "defaultEntityManager"
//)
public class AppDBConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource defaultDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean defaultEntityManager(
            EntityManagerFactoryBuilder builder, @Qualifier("defaultDataSource") DataSource source
    ){
        Map<String, String> properties = new HashMap<>();
        properties.put("spring.jpa.hibernate.ddl-auto", "create");
        return builder
                .dataSource(source)
                .properties(properties)
                .packages("org.ms.payroll.payroll.entities.payroll")
                .build();
    }
}
