package com.example.server.controller;

import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Jour_feriers;
import com.example.server.repository.Jour_feriersRepository;

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
public class Jour_feriersController {

	@Autowired

	private Jour_feriersRepository jour_feriersRepository;
	
	@GetMapping("/jour_feriers")
    public List<Jour_feriers> getJour_feriers() {
        return (List<Jour_feriers>) jour_feriersRepository.findAll();
    }
 
    @PostMapping("/jour_feriers")
    void addJour_feriers(@RequestBody Jour_feriers grade) {
        jour_feriersRepository.save(grade);
	}
	@GetMapping("/jour_feriers/{id}")
	public ResponseEntity<Jour_feriers> getJour_feriersById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Jour_feriers grade = jour_feriersRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Jour_feriers not found for this id :" + employeeId));
		return ResponseEntity.ok().body(grade);
	}

	

}
