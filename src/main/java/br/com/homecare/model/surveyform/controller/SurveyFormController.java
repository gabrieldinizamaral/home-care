package br.com.homecare.model.surveyform.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.homecare.model.surveyform.Section;
import br.com.homecare.model.surveyform.SectionsToSactionsResponseConverter;
import br.com.homecare.model.surveyform.repository.SurveyFormRepository;

@RestController
public class SurveyFormController {

	@Autowired
	private SectionsToSactionsResponseConverter converter;
	
	@Autowired
	private SurveyFormRepository surveyFormRepository;

	@RequestMapping(path = "survey-form", method = RequestMethod.GET)
	public ResponseEntity getSurveyForm() {
		Collection<Section> sections = (Collection<Section>) surveyFormRepository.findAll();
		if (sections.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(converter.convert(sections));
		}
	}

}
