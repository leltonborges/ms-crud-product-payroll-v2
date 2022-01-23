package org.ms.payroll.payroll.entities.payroll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ms.payroll.payroll.entities.product.Product;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_product_payroll")
public class ProductPayroll implements Serializable {
    @Serial
    private static final long serialVersionUID = 8072709861325168290L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long product;
    @Min(1)
    private Integer quantity;

    @ManyToOne
    private ProductSele sele;
}
