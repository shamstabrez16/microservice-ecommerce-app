package com.shamstabrez16.inventoryservice.controller;


import com.shamstabrez16.inventoryservice.dto.InventoryResponse;
import com.shamstabrez16.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

//    @GetMapping
//    public ResponseEntity<List<Inventory>> getAllInventory(){
//        return ResponseEntity.ok(service.getAllInventory());
//    }

//    @GetMapping("/{skuCode}")
//    public ResponseEntity<Boolean> isInStock(@PathVariable String skuCode){
//        return ResponseEntity.ok(service.isInStock(skuCode));
//    }

    @GetMapping()
    public ResponseEntity<List<InventoryResponse>> isInStock(@RequestParam List<String> skuCode){
        return ResponseEntity.ok(service.isInStock(skuCode));
    }
}
