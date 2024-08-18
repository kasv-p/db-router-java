package com.example.dbrouter.services;

import com.example.dbrouter.aop.UsingDb;
import com.example.dbrouter.dto.ItemDTO;
import com.example.dbrouter.entities.Item;
import com.example.dbrouter.enums.DatabaseType;
import com.example.dbrouter.enums.ErrorCode;
import com.example.dbrouter.exceptions.ApplicationException;
import com.example.dbrouter.repositories.ItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private ObjectMapper objectMapper;
    private ItemRepository itemRepository;

    public ItemDTO addItem(ItemDTO itemDTO) {
        Item item = Item.builder().description(itemDTO.getDescription()).build();
        item = itemRepository.save(item);
        return objectMapper.convertValue(item, ItemDTO.class);
    }

    @SneakyThrows
    public ItemDTO getItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isEmpty()) {
            throw new ApplicationException(ErrorCode.ITEM_NOT_FOUND);
        }
        return objectMapper.convertValue(item, ItemDTO.class);
    }

    @SneakyThrows
    public ItemDTO updateItem(ItemDTO itemDTO) {
        if (itemDTO.getId() == null) {
            throw new ApplicationException(ErrorCode.INVALID_ITEM_ID);
        }
        Optional<Item> item = itemRepository.findById(itemDTO.getId());
        if (item.isEmpty()) {
            throw new ApplicationException(ErrorCode.ITEM_NOT_FOUND);
        }
        item.get().setDescription(itemDTO.getDescription());
        return objectMapper.convertValue(itemRepository.save(item.get()), ItemDTO.class);
    }
}
