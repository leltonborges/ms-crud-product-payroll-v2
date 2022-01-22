package org.ms.payroll.payroll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSeleRepository extends JpaRepository<ProductSeleRepository, Long> {
}
