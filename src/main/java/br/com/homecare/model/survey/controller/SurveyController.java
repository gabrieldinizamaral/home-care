package br.com.homecare.model.survey.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
