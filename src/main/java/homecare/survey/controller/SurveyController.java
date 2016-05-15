package homecare.survey.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import homecare.carer.Carer;
import homecare.carer.repository.CarerRepository;
import homecare.survey.Survey;
import homecare.survey.repository.SurveyRepository;

@RestController
public class SurveyController {

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private CarerRepository carerRepository;

	@RequestMapping(path = "carer/{carerId}/surveys", method = RequestMethod.GET)
	public @ResponseBody Collection<Survey> getSurveysBy(@PathVariable Integer carerId) {
		Carer carer = carerRepository.findById(carerId);
		return surveyRepository.findByCarer(carer);
	}

}
