package com.example.server.repository;

import com.example.server.model.Retraite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RetraiteRepository extends CrudRepository<Retraite, Long>{

}