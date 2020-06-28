package com.example.server.repository;

import com.example.server.model.Type_avancement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Type_avancementRepository extends CrudRepository<Type_avancement, Long>{

}