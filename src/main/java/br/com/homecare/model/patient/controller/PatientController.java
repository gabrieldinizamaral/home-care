package br.com.homecare.model.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.homecare.model.patient.Patient;
import br.com.homecare.model.patient.PatientsToPatientsResponseConverter;
import br.com.homecare.model.patient.repository.PatientRepository;

@CrossOrigin
@RestController
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientsToPatientsResponseConverter converter;

	@RequestMapping(path = "/patients", method = RequestMethod.GET)
	public ResponseEntity get(){
		List<Patient> patients = (List<Patient>) patientRepository.findAll();
		if (patients.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(converter.convert(patients));
		}
	}

}
