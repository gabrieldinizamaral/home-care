package br.com.homecare.model.survey.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.homecare.model.carer.Carer;
import br.com.homecare.model.patient.Patient;
import br.com.homecare.model.survey.Response;
import br.com.homecare.model.survey.Survey;

@Component
public class SurveyToSurveyResponseConverter  implements Converter<Survey, SurveyResponse> {

	@Override
	public SurveyResponse convert(Survey survey) {
		SurveyResponse surveyResponse = new SurveyResponse();

		surveyResponse.setId(survey.getId());
		surveyResponse.setStartAt(survey.getStartAt());
		surveyResponse.setEndAt(survey.getEndAt());
		surveyResponse.setCarer(createCarer(survey.getCarer()));
		surveyResponse.setPatient(createPatient(survey.getPatient()));
		surveyResponse.setResponses(createResponses(survey.getResponses()));

		return surveyResponse;
	}

	private CarerResponse createCarer(Carer carer) {
		CarerResponse carerResponse = new CarerResponse();

		carerResponse.setId(carer.getId());
		carerResponse.setName(carer.getName());
		carerResponse.setRegistry(carer.getRegistry());

		return carerResponse;
	}

	private PatientResponse createPatient(Patient patient) {
		PatientResponse patientResponse = new PatientResponse();

		patientResponse.setId(patient.getId());
		patientResponse.setName(patient.getName());
		patientResponse.setAddress(patient.getAddress());
		patientResponse.setBirth(patient.getBirth());
		patientResponse.setGender(patient.getGender());
		patientResponse.setRegistry(patient.getRegistry());

		return patientResponse;
	}

	private List<ResponseResponse> createResponses(List<Response> responses) {
		List<ResponseResponse> responsesResponse = new ArrayList<ResponseResponse>();

		responses.forEach(response -> {
			ResponseResponse responseResponse = new ResponseResponse();

			responseResponse.setId(response.getId());
			responseResponse.setField(response.getFieldId());
			responseResponse.setResponse(response.getResponse());

			responsesResponse.add(responseResponse);
		});

		return responsesResponse;
	}

}
