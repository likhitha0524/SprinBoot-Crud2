package org.brillio.com.brillio.product.repository;

import jakarta.transaction.Transactional;
import org.brillio.com.brillio.product.domain.entity.ProductEntity;
import org.brillio.com.brillio.product.domain.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, BigDecimal>, JpaSpecificationExecutor<ProductEntity>
{
    ProductEntity findByProductNumber(BigDecimal productNumber);

    @Modifying
    @Query("UPDATE ProductEntity SET productDescription = ?2, productCategory = ?3 where productNumber = ?1")
    int updateProductDescAndCategory(BigDecimal productNumber, String desc, String cat);

}
