package org.ms.payroll.payroll.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    private Long id;
    private Integer stock;

}
