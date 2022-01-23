package org.ms.payroll.payroll.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ms.payroll.payroll.entities.payroll.ProductPayroll;
import org.ms.payroll.payroll.entities.payroll.ProductSele;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSeleDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 557250232627888L;
    private Long id;
    private Date date;
    private List<ProductPayroll> payrollList;

   }
