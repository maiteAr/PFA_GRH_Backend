
package com.example.server.repository;

import com.example.server.model.Permission;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long>{

}