package br.com.homecare.model.survey.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.homecare.model.carer.Carer;
import br.com.homecare.model.carer.repository.CarerRepository;
import br.com.homecare.model.survey.Survey;
import br.com.homecare.model.survey.repository.SurveyRepository;
import br.com.homecare.model.survey.response.SurveyResponse;
import br.com.homecare.model.survey.resquest.SurveyRequest;

@RestController
public class SurveyController {

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private CarerRepository carerRepository;

	@Autowired
	private ConversionService converter;

	@RequestMapping(path = "carers/{carerId}/surveys", method = RequestMethod.GET)
	public @ResponseBody Collection<Survey> getSurveysBy(@PathVariable Long carerId) {
		Optional<Carer> carer = carerRepository.findById(carerId);

		Collection<Survey> surveys = null;
		if (carer.isPresent()) {
			 surveys = surveyRepository.findByCarer(carer.get());
		}

		return surveys;
	}

	@RequestMapping(path = "surveys", method = RequestMethod.POST)
	public @ResponseBody SurveyResponse post(@RequestBody SurveyRequest surveyRequest) {
		Optional<Carer> carer = carerRepository.findById(surveyRequest.getCarer().getId());

		Survey survey = null;

		if (carer.isPresent()) {
			survey = converter.convert(surveyRequest, Survey.class);
			survey.setCarer(carer.get());
			survey = surveyRepository.save(survey);
		} else {
			//Tratar erros
		}

		return converter.convert(survey, SurveyResponse.class);
	}

}
