package com.example.server.repository;

import com.example.server.model.Echelon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EchelonRepository extends CrudRepository<Echelon, Long>{

}