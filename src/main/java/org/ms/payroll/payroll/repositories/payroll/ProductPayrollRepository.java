package org.ms.payroll.payroll.repositories.payroll;

import org.ms.payroll.payroll.entities.payroll.ProductPayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPayrollRepository extends JpaRepository<ProductPayroll, Long> {
}
