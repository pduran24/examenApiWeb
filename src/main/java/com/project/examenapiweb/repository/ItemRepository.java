package com.project.examenapiweb.repository;


import com.project.examenapiweb.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Repositorio de Item
 */
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    Optional<Item> findByItemId(Integer itemId);

    List<Item> countByCountLessThan(Integer countIsLessThan);
}