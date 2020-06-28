package com.example.server.repository;

import com.example.server.model.Jour_feriers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Jour_feriersRepository extends CrudRepository<Jour_feriers, Long>{

}