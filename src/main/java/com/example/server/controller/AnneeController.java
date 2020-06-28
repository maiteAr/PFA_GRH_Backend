package com.example.server.controller;
import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Annee;
import com.example.server.repository.AnneeRepository;


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
public class AnneeController {

	@Autowired

	private AnneeRepository absenceRepository;
	
	@GetMapping("/annees")
    public List<Annee> getAnnees() {
        return (List<Annee>) absenceRepository.findAll();
    }
 
    @PostMapping("/annees")
    void addAnnee(@RequestBody Annee absence) {
        absenceRepository.save(absence);
	}
	@GetMapping("/annees/{id}")
	public ResponseEntity<Annee> getAnneeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Annee fonction = absenceRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Absence not found for this id :" + employeeId));
		return ResponseEntity.ok().body(fonction);
	}
}
