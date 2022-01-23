package org.ms.payroll.payroll.repositories;

import org.ms.payroll.payroll.entities.ProductPayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPayrollRepository extends JpaRepository<ProductPayroll, Long> {
}
