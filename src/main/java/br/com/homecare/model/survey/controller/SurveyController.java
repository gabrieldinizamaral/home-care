package br.com.homecare.model.survey.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.homecare.model.carer.Carer;
import br.com.homecare.model.carer.repository.CarerRepository;
import br.com.homecare.model.patient.Patient;
import br.com.homecare.model.patient.repository.PatientRepository;
import br.com.homecare.model.survey.Survey;
import br.com.homecare.model.survey.repository.SurveyRepository;
import br.com.homecare.model.survey.response.SurveyResponse;
import br.com.homecare.model.survey.resquest.SurveyRequest;

@CrossOrigin
@RestController
public class SurveyController {

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private CarerRepository carerRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private ConversionService converter;

	@RequestMapping(path = "surveys", method = RequestMethod.POST)
	public ResponseEntity post(@RequestBody @Valid SurveyRequest surveyRequest) {
		Optional<Carer> carer = carerRepository.findById(surveyRequest.getCarer().getId());

		Survey survey = null;

		if (carer.isPresent()) {
			survey = converter.convert(surveyRequest, Survey.class);
			survey.setCarer(carer.get());
			survey = surveyRepository.save(survey);
		} else {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(converter.convert(survey, SurveyResponse.class));
	}

	@RequestMapping(path = "patients/{patientId}/surveys", method = RequestMethod.GET)
	public ResponseEntity getByPatient(@PathVariable Long patientId) {
		Optional<Patient> patient = patientRepository.findById(patientId);

		if (patient.isPresent()) {
			Survey survey = surveyRepository.findByPatient(patient.get());
			return ResponseEntity.ok(converter.convert(survey, SurveyResponse.class));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
