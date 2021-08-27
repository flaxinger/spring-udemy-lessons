package com.flaxinger.springlearnudemyfinal.model;

import org.springframework.data.repository.CrudRepository;

public interface StatusUpdateDao extends CrudRepository<StatusUpdate, Long> {
    StatusUpdate findFirstByOrderByAddedDesc();
}
