package com.example.server.controller;
import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Type_avancement;
import com.example.server.repository.Type_avancementRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class Type_avancementController {

	@Autowired

	private Type_avancementRepository type_avancementRepository;
	
	@GetMapping("/type_avancements")
    public List<Type_avancement> getType_avancements() {
        return (List<Type_avancement>) type_avancementRepository.findAll();
    }
 
    @PostMapping("/type_avancements")
    void addType_avancement(@RequestBody Type_avancement type_avancement) {
        type_avancementRepository.save(type_avancement);
	}
	@GetMapping("/type_avancements/{id}")
	public ResponseEntity<Type_avancement> getType_avancementById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Type_avancement type_avancement = type_avancementRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Type_avancement not found for this id :" + employeeId));
		return ResponseEntity.ok().body(type_avancement);
	}

	

}
