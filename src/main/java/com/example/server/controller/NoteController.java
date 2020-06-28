package com.example.server.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Note;
import com.example.server.repository.NoteRepository;

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
public class NoteController {

	@Autowired

	private NoteRepository noteRepository;
	
	@GetMapping("/notes")
    public List<Note> getNotes() {
        return (List<Note>) noteRepository.findAll();
    }
 
    @PostMapping("/notes")
    void addNote(@RequestBody Note note) {
        noteRepository.save(note);
	}
	@GetMapping("/notes/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Note note = noteRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Note not found for this id :" + employeeId));
		return ResponseEntity.ok().body(note);
	}

	@PutMapping("/notes/{id}")
	public ResponseEntity<Note> updateNote(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Note noteDetails) throws ResourceNotFoundException {
				Note note = noteRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Note not found for this id :: " + employeeId));

                note.setId_Annee(noteDetails.getId_annee());
                note.setNote(noteDetails.getNote());
                note.setEmployee(noteDetails.getEmployee());
        final Note updatedNote = noteRepository.save(note);
		return ResponseEntity.ok(updatedNote);
	}

	

}
