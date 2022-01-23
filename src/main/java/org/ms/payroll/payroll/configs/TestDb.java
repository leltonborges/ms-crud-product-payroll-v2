package org.ms.payroll.payroll.configs;

import org.ms.payroll.payroll.entities.payroll.ProductPayroll;
import org.ms.payroll.payroll.entities.payroll.ProductSele;
import org.ms.payroll.payroll.repositories.payroll.ProductPayrollRepository;
import org.ms.payroll.payroll.repositories.payroll.ProductSeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
@Profile("test")
public class TestDb implements CommandLineRunner {
    @Autowired
    private ProductPayrollRepository productPayrollRepository;
    @Autowired
    private ProductSeleRepository productSeleRepository;

    @Override
    public void run(String... args) throws Exception {
        ProductSele productSele = new ProductSele();

        List<ProductPayroll> payrollList = Arrays.asList(
                new ProductPayroll(null, 1l, 1, productSele),
                new ProductPayroll(null, 2l, 1, productSele),
                new ProductPayroll(null, 3l, 1, productSele));

        productSele.setData(new Date());
        productSele.setProducts(payrollList);

//        productSeleRepository.save(productSele);
    }
}
