package br.com.homecare.model.surveyform.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.homecare.model.surveyform.SurveyForm;
import br.com.homecare.model.surveyform.SurveyFormResponse;
import br.com.homecare.model.surveyform.repository.SurveyFormRepository;

@CrossOrigin
@RestController
public class SurveyFormController {

	@Autowired
	private ConversionService converter;

	@Autowired
	private SurveyFormRepository surveyFormRepository;

	@RequestMapping(path = "survey-forms/{surveyFormId}", method = RequestMethod.GET)
	public ResponseEntity getSurveyForm(@PathVariable Long surveyFormId) {
		Optional<SurveyForm> surveyForm = surveyFormRepository.findById(surveyFormId);
		if (surveyForm.isPresent()) {
			return ResponseEntity.ok(converter.convert(surveyForm.get(), SurveyFormResponse.class));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
