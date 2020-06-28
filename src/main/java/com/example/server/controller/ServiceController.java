package com.example.server.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Service;
import com.example.server.repository.ServiceRepository;

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
public class ServiceController {

	@Autowired

	private ServiceRepository serviceRepository;
	
	@GetMapping("/services")
    public List<Service> getServices() {
        return (List<Service>) serviceRepository.findAll();
    }
 
    @PostMapping("/services")
    void addService(@RequestBody Service service) {
        serviceRepository.save(service);
	}
	@GetMapping("/services/{id}")
	public ResponseEntity<Service> getServiceById(@PathVariable(value = "id") Long Id)
			throws ResourceNotFoundException {
        Service service = serviceRepository.findById(Id)
		.orElseThrow(() -> new ResourceNotFoundException("Service not found for this id :: " + Id));
		return ResponseEntity.ok().body(service);
	}

	@PutMapping("/services/{id}")
	public ResponseEntity<Service> updateService(@PathVariable(value = "id") Long Id,
			@Valid @RequestBody Service serviceDetails) throws ResourceNotFoundException {
				Service service = serviceRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Service not found for this id :: " + Id));

				service.setName(serviceDetails.getName());
				service.setDescription(serviceDetails.getDescription());
		final Service updatedService = serviceRepository.save(service);
		return ResponseEntity.ok(updatedService);
	}

	@DeleteMapping("/services/{id}")
	public Map<String, Boolean> deleteService(@PathVariable(value = "id") Long Id)
			throws ResourceNotFoundException {
                Service service = serviceRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Service not found for this id :: " + Id));

                serviceRepository.delete(service);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
