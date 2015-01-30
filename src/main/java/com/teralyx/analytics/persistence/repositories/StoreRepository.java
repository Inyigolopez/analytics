package com.teralyx.analytics.persistence.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.teralyx.analytics.persistence.entities.Store;

public interface StoreRepository extends MongoRepository<Store, Long> {

    Page<Store> findAll(Pageable pageable);

    Store findByNameAndCityAllIgnoringCase(String name, String city);

}
