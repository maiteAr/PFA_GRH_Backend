
package com.example.server.repository;

import com.example.server.model.Solde_jour_ouvrable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SoldeRepository extends CrudRepository<Solde_jour_ouvrable, Long>{
    
}