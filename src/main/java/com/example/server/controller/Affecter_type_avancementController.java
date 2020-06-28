package com.example.server.controller;
import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Affecter_type_avancement;
import com.example.server.repository.Affecter_type_avancementRepository;


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
public class Affecter_type_avancementController {

	@Autowired

	private Affecter_type_avancementRepository absenceRepository;
	
	@GetMapping("/affecter_type_avancements")
    public List<Affecter_type_avancement> getAffecter_type_avancements() {
        return (List<Affecter_type_avancement>) absenceRepository.findAll();
    }
 
    @PostMapping("/affecter_type_avancements")
    void addAffecter_type_avancement(@RequestBody Affecter_type_avancement absence) {
        absenceRepository.save(absence);
	}
	@GetMapping("/affecter_type_avancements/{id}")
	public ResponseEntity<Affecter_type_avancement> getAffecter_type_avancementById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Affecter_type_avancement fonction = absenceRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Absence_type not found for this id :" + employeeId));
		return ResponseEntity.ok().body(fonction);
	}

	

}
