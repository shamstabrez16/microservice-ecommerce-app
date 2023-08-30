package com.shamstabrez16.orderservice.service;

import com.shamstabrez16.orderservice.dto.OrderLineItemsDto;
import com.shamstabrez16.orderservice.dto.OrderRequest;
import com.shamstabrez16.orderservice.dto.OrderResponse;
import com.shamstabrez16.orderservice.model.Order;
import com.shamstabrez16.orderservice.model.OrderLineItems;
import com.shamstabrez16.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    @Transactional
    public void  createOrder(OrderRequest orderRequest) {

        Order order = Order.builder()
                .id(orderRequest.getId())
                .order_date(orderRequest.getOrder_date())
                .status(orderRequest.getStatus())
                .customer_name(orderRequest.getCustomer_name())
                .orderLineItems(orderRequest.getOrderLineItemsDtoList().stream().map(this::mapOrderLineItemsDtoToOrderLineItems).collect(Collectors.toList()))
                .total_amount(orderRequest.getTotal_amount())
                .build();
         orderRepository.save(order);
         log.info("Order by "+order.getCustomer_name()+" is saved!");
    }
    public List<OrderResponse> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
       return orders.stream().map(this::mapOrderToResponse).collect(Collectors.toList());
    }

    private OrderLineItems mapOrderLineItemsDtoToOrderLineItems(OrderLineItemsDto item){
        OrderLineItems orderLineItem = new OrderLineItems();
        orderLineItem.setId(item.getId());
        orderLineItem.setQuantity(item.getQuantity());
        orderLineItem.setSkuCode(item.getSkuCode());
        orderLineItem.setPrice(item.getPrice());
        return orderLineItem;

    }
    private OrderResponse mapOrderToResponse(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrder_date(order.getOrder_date());
        orderResponse.setId(order.getId());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setTotal_amount(order.getTotal_amount());
        orderResponse.setCustomer_name(order.getCustomer_name());
        return orderResponse;
    }
}
