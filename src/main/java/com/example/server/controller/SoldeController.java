package com.example.server.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Solde_jour_ouvrable;
import com.example.server.repository.SoldeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class SoldeController {

	@Autowired

	private SoldeRepository soldeRepository;
	
	@GetMapping("/soldes")
    public List<Solde_jour_ouvrable> getSoldes() {
        return (List<Solde_jour_ouvrable>) soldeRepository.findAll();
    }
 
    @PostMapping("/soldes")
    void addSolde(@RequestBody Solde_jour_ouvrable solde) {
        soldeRepository.save(solde);
	}
	@GetMapping("/soldes/{id}")
	public ResponseEntity<Solde_jour_ouvrable> getSoldeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Solde_jour_ouvrable solde = soldeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Grade not found for this id :" + employeeId));
		return ResponseEntity.ok().body(solde);
	}
	
	@PutMapping("/soldes/{id}")
	public ResponseEntity<Solde_jour_ouvrable> updateSolde(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Solde_jour_ouvrable noteDetails) throws ResourceNotFoundException {
				Solde_jour_ouvrable solde = soldeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Solde not found for this id : " + employeeId));

                solde.setId_Annee(noteDetails.getId_Annee());
                solde.setSolde(noteDetails.getSolde());
                solde.setEmployee(noteDetails.getEmployee());
        final Solde_jour_ouvrable updatedNote = soldeRepository.save(solde);
		return ResponseEntity.ok(updatedNote);
	}
	

}
