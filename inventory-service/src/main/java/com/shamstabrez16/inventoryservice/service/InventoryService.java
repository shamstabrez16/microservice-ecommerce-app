package com.shamstabrez16.inventoryservice.service;


import com.shamstabrez16.inventoryservice.dto.InventoryResponse;
import com.shamstabrez16.inventoryservice.model.Inventory;
import com.shamstabrez16.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public List<Inventory> getAllInventory (){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
       return repository.findBySkuCode(skuCode).isPresent();
    }
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return repository.findBySkuCodeIn(skuCode).stream()
                .map(inventory -> InventoryResponse.builder()
                        .SkuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() >0).build())
                .collect(Collectors.toList());
    }
}
