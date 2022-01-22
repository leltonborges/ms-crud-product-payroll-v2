package org.ms.payroll.payroll.dtos;

import lombok.Data;
import org.ms.crud.entities.Product;
import org.ms.payroll.payroll.entities.ProductSele;

@Data
public record ProductPayrollDTO(Long id, Product product, Integer quantity, ProductSele sele) {

}
