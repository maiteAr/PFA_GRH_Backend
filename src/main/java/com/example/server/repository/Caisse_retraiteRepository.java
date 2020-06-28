package com.example.server.repository;

import com.example.server.model.Caisse_retraite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Caisse_retraiteRepository extends CrudRepository<Caisse_retraite, Long>{

}