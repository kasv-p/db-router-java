package com.example.dbrouter.controllers;

import com.example.dbrouter.aop.UsingDb;
import com.example.dbrouter.dto.ItemDTO;
import com.example.dbrouter.enums.DatabaseType;
import com.example.dbrouter.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
@UsingDb(DatabaseType.WRITE)
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{id}")
    @UsingDb(DatabaseType.READ)
    public ResponseEntity<ItemDTO> getItem(@PathVariable("id") Long id) {
        return ResponseEntity.ok(itemService.getItem(id));
    }

    @PostMapping
    public ResponseEntity<ItemDTO> addItem(@RequestBody @Valid ItemDTO itemDTO) {
        return ResponseEntity.ok(itemService.addItem(itemDTO));
    }

    @PutMapping
    public ResponseEntity<ItemDTO> updateItem(@RequestBody @Valid ItemDTO itemDTO) {
        return ResponseEntity.ok(itemService.updateItem(itemDTO));
    }
}
