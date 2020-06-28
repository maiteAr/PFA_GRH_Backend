package com.example.server.controller;
import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Echelle;
import com.example.server.repository.EchelleRepository;


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
public class EchelleController {

	@Autowired

	private EchelleRepository echelleRepository;
	
	@GetMapping("/echelles")
    public List<Echelle> getEchelles() {
        return (List<Echelle>) echelleRepository.findAll();
    }
 
    @PostMapping("/echelles")
    void addEchelle(@RequestBody Echelle echelle) {
        echelleRepository.save(echelle);
	}
	@GetMapping("/echelles/{id}")
	public ResponseEntity<Echelle> getEchelleById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Echelle echelle = echelleRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Echelle not found for this id :" + employeeId));
		return ResponseEntity.ok().body(echelle);
	}

	

}
