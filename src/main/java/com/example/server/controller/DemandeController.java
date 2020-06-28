package com.example.server.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Demande;
import com.example.server.repository.DemandeRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class DemandeController {

	@Autowired

	private DemandeRepository demandeRepository;
	
	@GetMapping("/demandes")
    public List<Demande> getDemandes() {
        return (List<Demande>) demandeRepository.findAll();
    }
 
    @PostMapping("/demandes")
    void addDemande(@RequestBody Demande demande) {
        demandeRepository.save(demande);
	}
	@GetMapping("/demandes/{id}")
	public ResponseEntity<Demande> getDemandeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Demande demande = demandeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("demande not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(demande);
	}

	@PutMapping("/demandes/{id}")
	public ResponseEntity<Demande> updateDemande(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Demande demandeDetails) throws ResourceNotFoundException {
				Demande demande = demandeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Demande not found for this id :: " + employeeId));

				demande.setMotif(demandeDetails.getMotif());
                demande.setStatus(demandeDetails.getStatus());
                demande.setType(demandeDetails.getType());
                demande.setEmployee(demandeDetails.getEmployee());
        final Demande updatedDemande = demandeRepository.save(demande);
		return ResponseEntity.ok(updatedDemande);
	}

	@DeleteMapping("/demandes/{id}")
	public Map<String, Boolean> deleteDemande(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Demande fonction = demandeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Fonction not found for this id :: " + employeeId));

                demandeRepository.delete(fonction);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
