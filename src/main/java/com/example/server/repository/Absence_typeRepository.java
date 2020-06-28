
package com.example.server.repository;
import com.example.server.model.Absence_type;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Absence_typeRepository extends CrudRepository<Absence_type, Long>{

}