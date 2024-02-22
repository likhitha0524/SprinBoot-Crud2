package org.brillio.com.brillio.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    private BigDecimal productNumber;
    private String productDescription;
    private String productCategory;
}
