package com.shamstabrez16.inventoryservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@Entity
@Table(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_id", nullable = false)
    private Long id;
    private String skuCode;
    private LocalDate order_date;
    private int quantity;
}