package com.shamstabrez16.orderservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shamstabrez16.orderservice.dto.OrderRequest;
import com.shamstabrez16.orderservice.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class OrderServiceApplicationTests {

//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private OrderRepository orderRepository;
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//    @Container
//    static CustomPostgreSQLContainer postgresContainer = new CustomPostgreSQLContainer("postgres:9.6.12");
//
//    @DynamicPropertySource
//    static void setProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
//    }
//
//    @Test
//    void shouldCreateAOrder() throws Exception {
//        OrderRequest orderRequest = getOrderRequest();
//        String orderRequestString = objectMapper.writeValueAsString(orderRequest);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/order")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(orderRequestString))
//                .andExpect(status().isCreated());
//        Assertions.assertEquals(1, orderRepository.findAll().size());
//    }
//
//    private OrderRequest getOrderRequest() {
//        return OrderRequest.builder()
//                .customer_name("Shams")
//                .status("Pending")
//                .order_date(new Date())
//                .total_amount(60.0f).build();
//    }
}
