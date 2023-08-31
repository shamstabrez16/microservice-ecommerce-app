package com.shamstabrez16.orderservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_id", nullable = false)
    private Long id;
    private String customer_name;
    private Date order_date;
    private  float total_amount;
    private String status;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItems;


}