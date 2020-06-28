package com.example.server.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.server.exception.ResourceNotFoundException;
import com.example.server.model.Employee;
import com.example.server.repository.EmployeeRepository;

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
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setService(employeeDetails.getService());
		employee.setGendre(employeeDetails.getGendre());
		employee.setEtat(employeeDetails.getEtat());
		employee.setNationalite(employeeDetails.getNationalite());
		employee.setGrade(employeeDetails.getGrade());
		employee.setTel(employeeDetails.getTel());
		employee.setAdresse(employeeDetails.getAdresse());
		employee.setVille(employeeDetails.getVille());
		employee.setDiplome(employeeDetails.getDiplome());
		employee.setDateNaissance(employeeDetails.getDateNaissance());
		employee.setDateEmbauche(employeeDetails.getDateEmbauche());
		employee.setSalaire(employeeDetails.getSalaire());
		employee.setImage(employeeDetails.getImage());
		employee.setCin(employeeDetails.getCin());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@GetMapping(path = "/employees/getEmployeeImage/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getEmployeeImage(@PathVariable("id") Long id) throws Exception {
		Employee employee = employeeRepository.findById(id).get();
        String storingFolder = System.getProperty("user.home") + "/projet/employeesPictures/";
        return Files.readAllBytes(Paths.get(storingFolder + employee.getImage()));
    }
    @PostMapping(path = "/employees/uploadEmployeeImage/{id}")
    public void uploadEmployeeImage(MultipartFile file, @PathVariable Long id) throws Exception {

        String storingFolder = System.getProperty("user.home") + "/projet/employeesPictures/";
        String uniqueString = UUID.randomUUID().toString();

        Employee employee = employeeRepository.findById(id).get();
        employee.setImage(uniqueString + "_" + file.getOriginalFilename());

        Files.write(Paths.get(storingFolder + employee.getImage()), file.getBytes());

        employeeRepository.save(employee);
	}
	


}
