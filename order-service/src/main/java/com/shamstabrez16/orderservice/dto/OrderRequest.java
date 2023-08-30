package com.shamstabrez16.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long id;
    private String customer_name;
    private Date order_date;
    private  float total_amount;
    private String status;
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
