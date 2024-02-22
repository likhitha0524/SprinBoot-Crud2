package org.brillio.com.brillio.product.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "pnumber")
    private BigDecimal productNumber;

    @Column(name = "pdesc")
    private String productDescription;

    @Column(name = "category")
    private String productCategory;
}
