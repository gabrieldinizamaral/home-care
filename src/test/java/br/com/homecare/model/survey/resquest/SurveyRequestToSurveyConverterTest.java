package br.com.homecare.model.survey.resquest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.homecare.model.patient.Patient;
import br.com.homecare.model.survey.Response;
import br.com.homecare.model.survey.Survey;

public class SurveyRequestToSurveyConverterTest {

	private SurveyRequestToSurveyConverter converter;

	@Test
	public void shouldConvert() {
		converter = new SurveyRequestToSurveyConverter();

		SurveyRequest surveyRequest = createSurveyRequest();

		Survey survey = converter.convert(surveyRequest);

		assertEquals(surveyRequest.getStartAt(), survey.getStartAt());
		assertEquals(surveyRequest.getEndAt(), survey.getEndAt());
		assertNull(survey.getId());

		CarerRequest carerRequest = surveyRequest.getCarer();
		assertNotNull(carerRequest.getId());

		PatientRequest patientRequest = surveyRequest.getPatient();
		Patient patient = survey.getPatient();
		assertEquals(patientRequest.getName(), patient.getName());
		assertEquals(patientRequest.getRegistry(), patient.getRegistry());
		assertEquals(patientRequest.getBirth(), patient.getBirth());
		assertEquals(patientRequest.getAddress(), patient.getAddress());
		assertEquals(patientRequest.getGender(), patient.getGender().getValue());
		assertNull(patient.getId());

		List<ResponseRequest> responsesRequest = surveyRequest.getResponses();
		ResponseRequest responseRequest = responsesRequest.get(0);
		List<Response> responses = survey.getResponses();
		Response response = responses.get(0);
		assertEquals(responseRequest.getField(), response.getFieldId());
		assertEquals(responseRequest.getResponse(), response.getResponse());
		assertEquals(survey.getId(), response.getSurvey().getId());
		assertNull(response.getId());
	}

	private SurveyRequest createSurveyRequest() {
		SurveyRequest surveyRequest = new SurveyRequest();

		surveyRequest.setStartAt(OffsetDateTime.of(2016, 3, 4, 13, 44, 33, 342, ZoneOffset.UTC));
		surveyRequest.setEndAt(OffsetDateTime.of(2016, 3, 4, 13, 44, 33, 342, ZoneOffset.UTC));

		CarerRequest carer = new CarerRequest();

		carer.setId(1L);
		surveyRequest.setCarer(carer);

		PatientRequest patient = new PatientRequest();
		patient.setBirth(LocalDate.of(2016, 8, 13));
		patient.setAddress("Rua Augusta, 123 - São Paulo - SP");
		patient.setGender("feminino");
		patient.setName("Fulano de Tal");
		patient.setRegistry("AD124G");
		surveyRequest.setPatient(patient);

		List<ResponseRequest> responses = new ArrayList<ResponseRequest>();

		ResponseRequest response = new ResponseRequest();

		response.setResponse("resposta");
		response.setField(1L);
		responses.add(response);
		surveyRequest.setResponses(responses);

		return surveyRequest;
	}
}
