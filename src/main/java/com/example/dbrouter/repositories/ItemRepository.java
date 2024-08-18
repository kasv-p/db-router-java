package com.example.dbrouter.repositories;

import com.example.dbrouter.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
