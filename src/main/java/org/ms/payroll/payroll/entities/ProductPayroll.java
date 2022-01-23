package org.ms.payroll.payroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

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
    @Min(1)
    private Integer quantity;

    @OneToMany
    private List<Product> products;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSele sele;
}
