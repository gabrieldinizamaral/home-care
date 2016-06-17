package br.com.homecare.model.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.homecare.model.patient.Patient;
import br.com.homecare.model.patient.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;

	@RequestMapping(path = "/patients", method = RequestMethod.GET)
	public @ResponseBody List<Patient> get(){
		return (List<Patient>) patientRepository.findAll();
	}
	
}
