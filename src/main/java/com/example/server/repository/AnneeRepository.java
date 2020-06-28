package com.example.server.repository;

import com.example.server.model.Annee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnneeRepository extends CrudRepository<Annee, Long>{

}