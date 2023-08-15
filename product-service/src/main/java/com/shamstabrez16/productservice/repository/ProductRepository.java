package com.shamstabrez16.productservice.repository;

import com.shamstabrez16.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
