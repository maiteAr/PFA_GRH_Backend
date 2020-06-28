package com.example.server.controller;
import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Absence_type;
import com.example.server.repository.Absence_typeRepository;


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
public class Absence_typeController {

	@Autowired

	private Absence_typeRepository absenceRepository;
	
	@GetMapping("/absence_types")
    public List<Absence_type> getAbsence_types() {
        return (List<Absence_type>) absenceRepository.findAll();
    }
 
    @PostMapping("/absence_types")
    void addAbsence_type(@RequestBody Absence_type absence) {
        absenceRepository.save(absence);
	}
	@GetMapping("/absence_types/{id}")
	public ResponseEntity<Absence_type> getAbsence_typeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Absence_type fonction = absenceRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Absence_type not found for this id :" + employeeId));
		return ResponseEntity.ok().body(fonction);
	}

	

}
