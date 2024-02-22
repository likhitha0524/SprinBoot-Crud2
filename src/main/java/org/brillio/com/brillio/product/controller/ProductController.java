package org.brillio.com.brillio.product.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.brillio.com.brillio.product.domain.entity.ProductEntity;
import org.brillio.com.brillio.product.domain.model.ProductModel;
import org.brillio.com.brillio.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/product")
@CrossOrigin
@NoArgsConstructor
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{productNumber}")
    public ProductModel getProductDetail(@PathVariable BigDecimal productNumber) {
        return buildProductModel(productService.getProductDetails(productNumber));
    }

    @PostMapping
    public void insertProductDetails(@RequestBody ProductModel productModel) {
        productService.insertProductDetails(productModel);
    }

    @PutMapping("/{productNumber}")
    public ProductModel updateProductDetails(@PathVariable BigDecimal productNumber,
                                     @RequestBody ProductModel productModel) {
        return buildProductModel(productService.updateProductDetails(productNumber, productModel));
    }

    @PutMapping
    public void updateProductDetails(@RequestBody ProductModel productModel) {
        productService.updateProductDetails(productModel);
    }

    @DeleteMapping("/{productNumber}")
    public void deleteProductDetails(@PathVariable BigDecimal productNumber) {
        productService.deleteProductDetails(productNumber);
    }


    private ProductModel buildProductModel(ProductEntity productEntity){
        return ProductModel.builder()
                .productNumber(productEntity.getProductNumber())
                .productDescription(productEntity.getProductDescription())
                .productCategory(productEntity.getProductCategory())
                .build();
    }
}
