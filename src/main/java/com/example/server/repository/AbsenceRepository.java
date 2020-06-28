package com.example.server.repository;

import com.example.server.model.Absence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AbsenceRepository extends CrudRepository<Absence, Long>{

}