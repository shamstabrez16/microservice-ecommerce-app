package com.shamstabrez16.orderservice.controller;


import com.shamstabrez16.orderservice.dto.OrderRequest;
import com.shamstabrez16.orderservice.dto.OrderResponse;
import com.shamstabrez16.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderRequest OrderRequest){
        orderService.createOrder(OrderRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getOrders(){
        return orderService.getAllOrders();
    }
}
