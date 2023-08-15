package com.shamstabrez16.productservice.model;


import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Product")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
