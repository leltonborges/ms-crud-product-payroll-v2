package org.ms.payroll.payroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_product_seles")
public class ProductSele implements Serializable {
    @Serial
    private static final long serialVersionUID = -5731180759172832231L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seles",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ProductPayroll> products;

    @Min(1)
    private BigDecimal totalValue;
}
