package com.example.server.repository;

import com.example.server.model.Demande;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DemandeRepository extends CrudRepository<Demande, Long>{

}