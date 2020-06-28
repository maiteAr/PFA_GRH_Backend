package com.example.server.controller;
import java.util.List;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Grade;
import com.example.server.repository.GradeRepository;


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
public class GradeController {

	@Autowired

	private GradeRepository gradeRepository;
	
	@GetMapping("/grades")
    public List<Grade> getGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }
 
    @PostMapping("/grades")
    void addGrade(@RequestBody Grade grade) {
        gradeRepository.save(grade);
	}
	@GetMapping("/grades/{id}")
	public ResponseEntity<Grade> getGradeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Grade grade = gradeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Grade not found for this id :" + employeeId));
		return ResponseEntity.ok().body(grade);
	}

	

}
