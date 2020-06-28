package com.example.server.controller;
import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Echelon;
import com.example.server.repository.EchelonRepository;


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
public class EchelonController {

	@Autowired

	private EchelonRepository echelonRepository;
	
	@GetMapping("/echelons")
    public List<Echelon> getEchelons() {
        return (List<Echelon>) echelonRepository.findAll();
    }
 
    @PostMapping("/echelons")
    void addEchelon(@RequestBody Echelon echelon) {
        echelonRepository.save(echelon);
	}
	@GetMapping("/echelons/{id}")
	public ResponseEntity<Echelon> getEchelonById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Echelon echelon = echelonRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("echelon not found for this id :" + employeeId));
		return ResponseEntity.ok().body(echelon);
	}

	

}
