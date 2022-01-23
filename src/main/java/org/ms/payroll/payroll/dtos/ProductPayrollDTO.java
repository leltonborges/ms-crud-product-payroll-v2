package org.ms.payroll.payroll.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ms.payroll.payroll.entities.Product;
import org.ms.payroll.payroll.entities.ProductSele;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPayrollDTO
        implements Serializable {
    @Serial
    private static final long serialVersionUID = -257250232187627888L;
    private Long id;
    private Integer quantity;
    private List<Product> products;
    @JsonIgnore
    private ProductSele sele;

}
