package br.com.homecare.model.survey.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.homecare.model.carer.Carer;
import br.com.homecare.model.carer.repository.CarerRepository;
import br.com.homecare.model.survey.Survey;
import br.com.homecare.model.survey.repository.SurveyRepository;
import br.com.homecare.model.surveyform.Section;

@RestController
public class SurveyController {

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private CarerRepository carerRepository;

	@RequestMapping(path = "carer/{carerId}/surveys", method = RequestMethod.GET)
	public @ResponseBody Collection<Survey> getSurveysBy(@PathVariable Integer carerId) {
		Optional<Carer> carer = carerRepository.findById(carerId);

		Collection<Survey> surveys = surveyRepository.findByCarer(carer.get());

		return surveys;
	}

}
