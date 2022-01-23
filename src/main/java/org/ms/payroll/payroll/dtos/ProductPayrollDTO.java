package org.ms.payroll.payroll.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ms.payroll.payroll.entities.ProductSele;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPayrollDTO
        implements Serializable {
    @Serial
    private static final long serialVersionUID = -257250232187627888L;
    private Long id;
    private Long product;
    private Integer quantity;
    @JsonIgnore
    private ProductSele sele;

}
