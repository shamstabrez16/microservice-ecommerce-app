package com.shamstabrez16.inventoryservice.service;


import com.shamstabrez16.inventoryservice.model.Inventory;
import com.shamstabrez16.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
