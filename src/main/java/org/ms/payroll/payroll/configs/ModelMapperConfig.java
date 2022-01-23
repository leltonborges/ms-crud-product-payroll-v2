package org.ms.payroll.payroll.configs;

import org.modelmapper.ModelMapper;
import org.ms.payroll.payroll.dtos.ProductPayrollDTO;
import org.ms.payroll.payroll.entities.payroll.ProductPayroll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper instanceModelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(ProductPayrollDTO.class, ProductPayroll.class);

        mapper.createTypeMap(ProductPayroll.class, ProductPayrollDTO.class);

        return mapper;
    }
}
