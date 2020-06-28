package com.example.server.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Promotion;
import com.example.server.repository.PromotionRepository;


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
public class PromotionController {

	@Autowired

	private PromotionRepository promotionRepository;
	
	@GetMapping("/promotions")
    public List<Promotion> getPromotions() {
        return (List<Promotion>) promotionRepository.findAll();
    }
 
    @PostMapping("/promotions")
    void addPromotion(@RequestBody Promotion promotion) {
        promotionRepository.save(promotion);
	}
	@GetMapping("/promotions/{id}")
	public ResponseEntity<Promotion> getPromotionById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
                Promotion promotion = promotionRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Promotion not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(promotion);
	}

	@PutMapping("/promotions/{id}")
	public ResponseEntity<Promotion> updatePromotion(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Promotion promotionDetails) throws ResourceNotFoundException {
				Promotion promotion = promotionRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("promotion not found for this id :: " + employeeId));
				promotion.setNote_moyenne(promotionDetails.getNote_moyenne());
                promotion.setStatus(promotionDetails.getStatus());
                promotion.setType(promotionDetails.getType());
				promotion.setEmployee(promotionDetails.getEmployee());
				promotion.setNv(promotionDetails.getNv());
				promotion.setAc(promotionDetails.getAc());
        final Promotion updatedPermission = promotionRepository.save(promotion);
		return ResponseEntity.ok(updatedPermission);
	}

	@DeleteMapping("/promotions/{id}")
	public Map<String, Boolean> deletePromotion(@PathVariable(value = "id") Long Id)
			throws ResourceNotFoundException {
                Promotion promotion = promotionRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("promotion not found for this id :: " + Id));

                promotionRepository.delete(promotion);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
