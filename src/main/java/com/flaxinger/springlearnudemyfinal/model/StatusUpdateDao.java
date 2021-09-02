package com.flaxinger.springlearnudemyfinal.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

//PagingAndSortingRepository inherits from CrudRepository Interface and therefore supports all that CruRepository provides
public interface StatusUpdateDao extends PagingAndSortingRepository<StatusUpdate, Long> {
    StatusUpdate findFirstByOrderByAddedDesc();

}
