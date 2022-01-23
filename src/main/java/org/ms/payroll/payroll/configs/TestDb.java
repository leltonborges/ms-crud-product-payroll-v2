package org.ms.payroll.payroll.configs;

import org.ms.payroll.payroll.entities.Product;
import org.ms.payroll.payroll.entities.ProductPayroll;
import org.ms.payroll.payroll.entities.ProductSele;
import org.ms.payroll.payroll.repositories.ProductPayrollRepository;
import org.ms.payroll.payroll.repositories.ProductRepository;
import org.ms.payroll.payroll.repositories.ProductSeleRepository;
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
    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product(null, 100);
        Product product2 = new Product(null, 200);
        Product product3 = new Product(null, 50);
        Product product4 = new Product(null, 30);
        Product product5 = new Product(null, 600);
        Product product6 = new Product(null, 15);
        Product product7 = new Product(null, 200);
        Product product8 = new Product(null, 50);
        Product product9 = new Product(null, 30);
        Product product10 = new Product(null, 600);
        Iterable<Product> products = Arrays.asList(product1,product2, product3, product4,
                product5, product6, product7, product8, product9, product10);

        ProductSele productSele1 = new ProductSele();
        ProductSele productSele2 = new ProductSele();
        ProductSele productSele3 = new ProductSele();
        Iterable<ProductSele> productSeles = Arrays.asList(productSele1, productSele2, productSele3);

        ProductPayroll productPayroll1 = new ProductPayroll(null, 16, Arrays.asList(product1, product2,product3), productSele1);
        ProductPayroll productPayroll3 = new ProductPayroll(null, 20, Arrays.asList(product5, product4, product6), productSele2);
        ProductPayroll productPayroll2 = new ProductPayroll(null, 30, Arrays.asList(product7, product8, product9, product10), productSele3);
        Iterable<ProductPayroll> productPayrolls = Arrays.asList(productPayroll2, productPayroll1, productPayroll3);

        List<ProductPayroll> payrollList1 = Arrays.asList(productPayroll1);
        List<ProductPayroll> payrollList2 = Arrays.asList(productPayroll2);
        List<ProductPayroll> payrollList3 = Arrays.asList(productPayroll3);

        productSele1.setProducts(payrollList1);
        productSele2.setProducts(payrollList2);
        productSele3.setProducts(payrollList3);

//        productRepository.saveAll(products);
//        productSeleRepository.saveAll(productSeles);
//        productPayrollRepository.saveAll(productPayrolls);
    }
}
