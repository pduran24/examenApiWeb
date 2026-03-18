package com.project.examenapiweb.service;

import com.project.examenapiweb.config.ItemConfig;
import com.project.examenapiweb.dto.StatsDTO;
import com.project.examenapiweb.exception.ItemNotFoundException;
import com.project.examenapiweb.model.Item;
import com.project.examenapiweb.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemConfig itemConfig;


    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(int itemId) {
        return itemRepository.findByItemId(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item con id " + itemId + " no encontrado"));
    }

    public Item findByEan(String ean) {
        return itemRepository.findByEan(ean)
                .orElseThrow(() -> new ItemNotFoundException("Item con ean " + ean + " no encontrado"));
    }

    public void updateItem(Item itemModificado) {
        Item itemOriginal = this.findById(itemModificado.getItemId());

        itemModificado.set_id(itemOriginal.get_id());

        itemRepository.save(itemModificado);
    }

    public StatsDTO getStats() {
        List<String> manufacturers = itemRepository.findAll()
                .stream()
                .map(Item::getManufacturer)
                .distinct()
                .toList();

        return new  StatsDTO(
                itemRepository.count(),
                itemRepository.countByCountLessThan(itemConfig.getMinStock()),
                manufacturers
        );
    }

}
