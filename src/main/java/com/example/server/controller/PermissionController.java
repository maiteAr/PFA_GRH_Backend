
package com.example.server.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Permission;
import com.example.server.repository.PermissionRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PermissionController {

	@Autowired

	private PermissionRepository permissionRepository;
	
	@GetMapping("/permissions")
    public List<Permission> getPermissions() {
        return (List<Permission>) permissionRepository.findAll();
    }
 
    @PostMapping("/permissions")
    void addPermission(@RequestBody Permission permission) {
        permissionRepository.save(permission);
	}
	@GetMapping("/permissions/{id}")
	public ResponseEntity<Permission> getPermissionById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Permission permission = permissionRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Permission not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(permission);
	}

	@PutMapping("/permissions/{id}")
	public ResponseEntity<Permission> updatePermission(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Permission permissionDetails) throws ResourceNotFoundException {
				Permission permission = permissionRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Permission not found for this id :: " + employeeId));

				permission.setMotif(permissionDetails.getMotif());
                permission.setStatus(permissionDetails.getStatus());
                permission.setType(permissionDetails.getType());
				permission.setEmployee(permissionDetails.getEmployee());
				permission.setDateDebut(permissionDetails.getDateDebut());
				permission.setDateFin(permissionDetails.getDateFin());
				permission.setDateReprise(permissionDetails.getDateReprise());
        final Permission updatedPermission = permissionRepository.save(permission);
		return ResponseEntity.ok(updatedPermission);
	}

	@DeleteMapping("/permissions/{id}")
	public Map<String, Boolean> deletePermission(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Permission fonction = permissionRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Permission not found for this id :: " + employeeId));

                permissionRepository.delete(fonction);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
