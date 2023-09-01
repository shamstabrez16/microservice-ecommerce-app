package com.shamstabrez16.productservice.model;


import jakarta.persistence.*;
import lombok.*;



@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id", nullable = false)
    private Long id;
    @Column(name = "product_name", nullable = false)
    private String product_name;
    @Column(name = "price", nullable = false)
    private float price;
    @Column(name = "description")
    private String description;
}
