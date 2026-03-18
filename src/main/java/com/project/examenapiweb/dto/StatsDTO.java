package com.project.examenapiweb.dto;

import com.project.examenapiweb.model.Item;

import java.util.List;


public record StatsDTO(
        Long totalItems,
        List<Item> itemsLowStock,
        List<String> manufacturers
) {
}
