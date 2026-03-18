package com.project.examenapiweb.repository;


import com.project.examenapiweb.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    void deleteByItemId(Integer itemId);
    Optional<Item> findByItemId(Integer itemId);
    Optional<Item> findByEan(String ean);

    Optional<List<Item>> findByCategory(String category);

    List<Item> countByCountLessThan(Integer countIsLessThan);
}