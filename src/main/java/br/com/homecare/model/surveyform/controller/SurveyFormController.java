package br.com.homecare.model.surveyform.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.homecare.model.surveyform.Section;
import br.com.homecare.model.surveyform.SectionResponse;
import br.com.homecare.model.surveyform.SectionsToSactionsResponseConverter;
import br.com.homecare.model.surveyform.repository.SurveyFormRepository;

@RestController
public class SurveyFormController {

	@Autowired
	private SectionsToSactionsResponseConverter converter;
	
	@Autowired
	private SurveyFormRepository surveyFormRepository;

	@RequestMapping(path = "survey-form", method = RequestMethod.GET)
	public @ResponseBody Collection<SectionResponse> getSurveyForm() {
		Collection<Section> sections = (Collection<Section>) surveyFormRepository.findAll();
		return converter.convert(sections);
	}

}
