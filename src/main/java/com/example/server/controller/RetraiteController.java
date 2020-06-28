package com.example.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Retraite;
import com.example.server.repository.RetraiteRepository;


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
public class RetraiteController {

	@Autowired

	private RetraiteRepository retraiteRepository;
	
	@GetMapping("/retraites")
    public List<Retraite> getRetraites() {
        return (List<Retraite>) retraiteRepository.findAll();
    }
 
    @PostMapping("/retraites")
    void addRetraite(@RequestBody Retraite absence) {
        retraiteRepository.save(absence);
	}
	@GetMapping("/retraites/{id}")
	public ResponseEntity<Retraite> getRetraiteById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Retraite retraite = retraiteRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Retraite not found for this id : " + employeeId));
		return ResponseEntity.ok().body(retraite);
	}

	@PutMapping("/retraites/{id}")
	public ResponseEntity<Retraite> updateRetraite(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Retraite retraiteDetails) throws ResourceNotFoundException {
				Retraite retraite = retraiteRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Retraite not found for this id : " + employeeId));
                retraite.setSalaire_base(retraiteDetails.getSalaire_base());
                retraite.setIndice_residence(retraiteDetails.getIndice_residence());
                retraite.setIndice_familialle(retraiteDetails.getIndice_familialle());
                retraite.setIndice_difficulte(retraiteDetails.getIndice_difficulte());
                retraite.setIndice_graduation(retraiteDetails.getIndice_graduation());
                retraite.setSalaire_annuel_brut(retraiteDetails.getSalaire_annuel_brut());
                retraite.setSalaire_mensuel_brut(retraiteDetails.getSalaire_mensuel_brut());
                retraite.setSalaire_mensuel_net(retraiteDetails.getSalaire_mensuel_net());
                retraite.setCoti_retraite(retraiteDetails.getCoti_retraite());
                retraite.setCoti_mutuelle(retraiteDetails.getCoti_mutuelle());
                retraite.setDate_retraite(retraiteDetails.getDate_retraite());
                retraite.setType(retraiteDetails.getType());
                retraite.setEmployee(retraiteDetails.getEmployee());
        final Retraite updatedRetraite = retraiteRepository.save(retraite);
		return ResponseEntity.ok(updatedRetraite);
	}

	@DeleteMapping("/retraites/{id}")
	public Map<String, Boolean> deleteRetraite(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Retraite retraite = retraiteRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Retraite not found for this id : " + employeeId));

                retraiteRepository.delete(retraite);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
