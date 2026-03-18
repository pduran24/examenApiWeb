package com.project.examenapiweb.dto;

import com.project.examenapiweb.model.Item;

import java.util.List;

/**
 * DTO de respuesta para la Historia D - Estadísticas de la tienda.
 * a) totalItems, b) itemsLowStock, c) manufacturers
 */
public record StatsDTO(
        Long totalItems,
        List<Item> itemsLowStock,
        List<String> manufacturers
) {
}
