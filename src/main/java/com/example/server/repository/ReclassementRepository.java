package com.example.server.repository;

import com.example.server.model.Reclassement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclassementRepository extends CrudRepository<Reclassement, Long>{

}