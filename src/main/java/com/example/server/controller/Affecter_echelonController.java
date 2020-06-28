package com.example.server.controller;
import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Affecter_echelon;
import com.example.server.repository.Affecter_echelonRepository;


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
public class Affecter_echelonController {

	@Autowired

	private Affecter_echelonRepository affecter_echelonRepository;
	
	@GetMapping("/affecter_echelons")
    public List<Affecter_echelon> getAffecter_echelons() {
        return (List<Affecter_echelon>) affecter_echelonRepository.findAll();
    }
 
    @PostMapping("/affecter_echelons")
    void addAffecter_echelon(@RequestBody Affecter_echelon absence) {
        affecter_echelonRepository.save(absence);
	}
	@GetMapping("/affecter_echelons/{id}")
	public ResponseEntity<Affecter_echelon> getAffecter_echelonById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Affecter_echelon fonction = affecter_echelonRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Affecter_echelon not found for this id : " + employeeId));
		return ResponseEntity.ok().body(fonction);
	}

	

}
