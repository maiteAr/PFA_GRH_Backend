package com.example.server.controller;
import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Cadre;
import com.example.server.repository.CadreRepository;


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
public class CadreController {

	@Autowired

	private CadreRepository absenceRepository;
	
	@GetMapping("/cadres")
    public List<Cadre> getCadres() {
        return (List<Cadre>) absenceRepository.findAll();
    }
 
    @PostMapping("/cadres")
    void addCadre(@RequestBody Cadre absence) {
        absenceRepository.save(absence);
	}
	@GetMapping("/cadres/{id}")
	public ResponseEntity<Cadre> getCadreById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Cadre fonction = absenceRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("cadre not found for this id :" + employeeId));
		return ResponseEntity.ok().body(fonction);
	}

	

}
