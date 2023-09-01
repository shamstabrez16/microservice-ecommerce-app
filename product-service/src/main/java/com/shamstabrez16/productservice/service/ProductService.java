package com.shamstabrez16.productservice.service;


import com.shamstabrez16.productservice.dto.ProductRequest;
import com.shamstabrez16.productservice.dto.ProductResponse;
import com.shamstabrez16.productservice.model.Product;
import com.shamstabrez16.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public  void createProduct(ProductRequest productRequest){
       Product product =  Product.builder()
                .product_name(productRequest.getProduct_name())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription()).build();
        productRepository.save(product);
        log.info("Product "+ product.getProduct_name()+"  saved");

    }

    public List<ProductResponse> getProducts() {
       List<Product> products=  productRepository.findAll();
       return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }
    private ProductResponse mapToProductResponse(Product product){
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setProduct_name(product.getProduct_name());
        response.setPrice(product.getPrice());
        return response;
    }
}
