package com.springboot.healthcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.healthcare.exception.ResourceNotFoundException;
import com.springboot.healthcare.model.Diagnostic;
import com.springboot.healthcare.repository.DiagnosticRepository;

@RestController
@RequestMapping("/api/h1/")
public class DiagnosticController {
	@Autowired
	private DiagnosticRepository diagnosticrepository;
	
	//get the diagnostic
	@GetMapping("diagnostic")
	public List<Diagnostic> getAlldiagnostic(){
		return diagnosticrepository.findAll();
	}
	
	//crud operations
	//create
	@PostMapping("/diagnostic")
	public Diagnostic createDiagnostic(@RequestBody Diagnostic diagnostic) {
		return diagnosticrepository.save(diagnostic);
	}
	
	//get diagnostic  by Id rest API
	@GetMapping("/diagnostic/{id}")
	public ResponseEntity<Diagnostic> getDiagnosticById(@PathVariable long id){
		Diagnostic diagnostic = diagnosticrepository.findById(id)
				.orElseThrow(()->
				new ResourceNotFoundException("Diagnostic not exists with id:"+id));
		return ResponseEntity.ok(diagnostic);
	}
	
	//update diagnostic rest API
	@PutMapping("/diagnostic/{id}")
	public ResponseEntity<Diagnostic> updateDiagnostic(@PathVariable long id,
			@RequestBody Diagnostic diagnosticDetails){
		Diagnostic diagnostic = diagnosticrepository.findById(id)
				.orElseThrow( ()->
				new ResourceNotFoundException("Diagnostic not exists with id:" +id));
		diagnostic.setCentername(diagnosticDetails.getCentername());
		diagnostic.setListoftest(diagnosticDetails.getListoftest());
		diagnostic.setAppointmentlist(diagnosticDetails.getAppointmentlist());
		
		Diagnostic updateDiagnostic=diagnosticrepository.save(diagnostic);
		return ResponseEntity.ok(updateDiagnostic);
		
	}
	
	@DeleteMapping("/diagnostic/{id}")
	public Map<String,Boolean> deleteDiagnostic(@PathVariable(value="id")long id)
			throws ResourceNotFoundException{
			Diagnostic diagnostic=diagnosticrepository.findById(id)
			.orElseThrow( ()->
			new ResourceNotFoundException("Diagnostic not exists with id:"+id));
	
	diagnosticrepository.delete(diagnostic);
	Map<String,Boolean> response=new HashMap<>();
	response.put("deleted",Boolean.TRUE);
	return response;
}
	
}