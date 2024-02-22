package org.brillio.com.brillio.product.service;

import org.brillio.com.brillio.product.domain.entity.ProductEntity;
import org.brillio.com.brillio.product.domain.model.ProductModel;
import org.brillio.com.brillio.product.exception.NotFoundException;
import org.brillio.com.brillio.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity getProductDetails(BigDecimal productNumber){
        ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
        if (productEntity == null){
            throw new RuntimeException("No product details found for product number:" + productNumber);
        }
        return productEntity;
    }

    public void insertProductDetails(ProductModel productModel){
        ProductEntity productEntity = ProductEntity.builder()
                .productNumber(productModel.getProductNumber())
                .productDescription(productModel.getProductDescription())
                .productCategory(productModel.getProductCategory())
                .build();

        productRepository.save(productEntity);
    }

    public ProductEntity updateProductDetails(BigDecimal productNumber,ProductModel productModel){
        ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
        if (productEntity == null){
            throw new RuntimeException("No product details found for product number:" + productNumber);
        }
        productEntity.setProductDescription(productModel.getProductDescription());
        productEntity.setProductCategory(productModel.getProductCategory());

        return productRepository.save(productEntity);
    }


    public void updateProductDetails(ProductModel productModel){
        int updatedRows = productRepository.updateProductDescAndCategory(productModel.getProductNumber(),
                productModel.getProductDescription(), productModel.getProductCategory());
        if (updatedRows != 1){
            throw new NotFoundException("No product details found for product number:" + productModel.getProductNumber());
        }
    }

    public void deleteProductDetails(BigDecimal productNumber)
    {
        ProductEntity productEntity = productRepository.findByProductNumber(productNumber);
        if (productEntity == null){
            throw new RuntimeException("No product details found for product number:" + productNumber +"to delete");
        }
        productRepository.deleteById(productNumber);

    }
}
