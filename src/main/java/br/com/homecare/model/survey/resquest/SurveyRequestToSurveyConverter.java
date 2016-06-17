package br.com.homecare.model.survey.resquest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.homecare.model.patient.Patient;
import br.com.homecare.model.survey.Response;
import br.com.homecare.model.survey.Survey;

@Component
public class SurveyRequestToSurveyConverter implements Converter<SurveyRequest, Survey>{

	public Survey convert(SurveyRequest surveyRequest) {
		Survey survey = new Survey();

		survey.setStartAt(surveyRequest.getStartAt());
		survey.setEndAt(surveyRequest.getEndAt());
		survey.setPatient(createPatient(surveyRequest.getPatient()));
		survey.setResponses(createResponses(surveyRequest.getResponses(), survey));

		return survey;
	}

	private Patient createPatient(PatientRequest patientRequest) {
		Patient patient = new Patient();

		patient.setName(patientRequest.getName());
		patient.setAddress(patientRequest.getAddress());
		patient.setBirth(patientRequest.getBirth());
		patient.setGender(patientRequest.getGender());
		patient.setRegistry(patientRequest.getRegistry());

		return patient;
	}

	private List<Response> createResponses(List<ResponseRequest> responsesRequest, Survey survey) {
		List<Response> responses = new ArrayList<Response>();

		responsesRequest.forEach(responseRequest -> {
			Response response = new Response();

			response.setFieldId(responseRequest.getField());
			response.setResponse(responseRequest.getResponse());
			response.setSurvey(survey);

			responses.add(response);

		});

		return responses;
	}
	
}
