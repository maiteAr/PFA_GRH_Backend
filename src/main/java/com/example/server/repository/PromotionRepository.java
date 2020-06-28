package com.example.server.repository;


import com.example.server.model.Promotion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Long>{

}