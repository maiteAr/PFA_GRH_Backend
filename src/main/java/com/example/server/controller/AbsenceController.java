package com.example.server.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Absence;
import com.example.server.repository.AbsenceRepository;


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
public class AbsenceController {

	@Autowired

	private AbsenceRepository absenceRepository;
	
	@GetMapping("/absences")
    public List<Absence> getAbsences() {
        return (List<Absence>) absenceRepository.findAll();
    }
 
    @PostMapping("/absences")
    void addAbsence(@RequestBody Absence absence) {
        absenceRepository.save(absence);
	}
	@GetMapping("/absences/{id}")
	public ResponseEntity<Absence> getAbsenceById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Absence fonction = absenceRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Fonction not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(fonction);
	}

	@PutMapping("/absences/{id}")
	public ResponseEntity<Absence> updateAbsence(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Absence absenceDetails) throws ResourceNotFoundException {
				Absence absence = absenceRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Fonction not found for this id :: " + employeeId));

				
                absence.setDateDebut(absenceDetails.getDateDebut());
				absence.setDateFin(absenceDetails.getDateFin());
				absence.setId_annee(absenceDetails.getId_annee());
				absence.setNb_jours(absenceDetails.getNb_jours());
                absence.setType(absenceDetails.getType());
                absence.setEmployee(absenceDetails.getEmployee());
        final Absence updatedAbsence = absenceRepository.save(absence);
		return ResponseEntity.ok(updatedAbsence);
	}

	@DeleteMapping("/absences/{id}")
	public Map<String, Boolean> deleteAbsence(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Absence fonction = absenceRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Fonction not found for this id :: " + employeeId));

                absenceRepository.delete(fonction);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
