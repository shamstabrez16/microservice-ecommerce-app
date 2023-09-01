package com.shamstabrez16.orderservice.service;

import com.shamstabrez16.orderservice.dto.InventoryResponse;
import com.shamstabrez16.orderservice.dto.OrderLineItemsDto;
import com.shamstabrez16.orderservice.dto.OrderRequest;
import com.shamstabrez16.orderservice.dto.OrderResponse;
import com.shamstabrez16.orderservice.model.Order;
import com.shamstabrez16.orderservice.model.OrderLineItems;
import com.shamstabrez16.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient webClient;
    @Autowired
    public OrderService(OrderRepository orderRepository,WebClient webClient) {
        this.orderRepository = orderRepository;
        this.webClient = webClient;
    }
    @Transactional
    public void  createOrder( OrderRequest orderRequest) {


        System.out.println("createOrder");
        Order order = Order.builder()
                .id(orderRequest.getId())
                .order_date(orderRequest.getOrder_date())
                .status(orderRequest.getStatus())
                .customer_name(orderRequest.getCustomer_name())
                .orderLineItems(orderRequest.getOrderLineItemsDtoList().stream().map(this::mapOrderLineItemsDtoToOrderLineItems).collect(Collectors.toList()))
                .total_amount(orderRequest.getTotal_amount())
                .build();
        System.out.println("createOrder - built");
       List<String> skuCodes = order.getOrderLineItems()
               .stream()
               .map(OrderLineItems::getSkuCode)
               .toList();
       skuCodes.forEach(System.out::println);
        InventoryResponse[] inventoryResponses= webClient.get()
                .uri("http://localhost:8083/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        boolean AllProductsInStock = false;
        if(inventoryResponses!=null){
            AllProductsInStock =  Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);    
        }

        if(AllProductsInStock){
            orderRepository.save(order);
        }
        else {
            throw  new IllegalArgumentException("Product not in stock, Please try again later");
        }

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
