package com.example.server.controller;

import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Caisse_retraite;
import com.example.server.repository.Caisse_retraiteRepository;


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
public class Caisse_retraiteController {

	@Autowired

	private Caisse_retraiteRepository retraiteRepository;
	
	@GetMapping("/caisse_retraites")
    public List<Caisse_retraite> getCaisse_retraites() {
        return (List<Caisse_retraite>) retraiteRepository.findAll();
    }
 
    @PostMapping("/caisse_retraites")
    void addCaisse_retraite(@RequestBody Caisse_retraite absence) {
        retraiteRepository.save(absence);
	}
	@GetMapping("/caisse_retraites/{id}")
	public ResponseEntity<Caisse_retraite> getCaisse_retraiteById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Caisse_retraite retraite = retraiteRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Caisse_retraite not found for this id : " + employeeId));
		return ResponseEntity.ok().body(retraite);
	}

	
}
