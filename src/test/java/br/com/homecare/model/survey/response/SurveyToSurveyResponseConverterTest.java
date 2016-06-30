package br.com.homecare.model.survey.response;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.homecare.model.carer.Carer;
import br.com.homecare.model.patient.Gender;
import br.com.homecare.model.patient.Patient;
import br.com.homecare.model.patient.PatientResponse;
import br.com.homecare.model.survey.Response;
import br.com.homecare.model.survey.Survey;

public class SurveyToSurveyResponseConverterTest {

	private SurveyToSurveyResponseConverter converter;

	@Test
	public void shouldConvert() {
		converter = new SurveyToSurveyResponseConverter();

		Survey survey = createSurvey();

		SurveyResponse surveyResponse = converter.convert(survey);

		assertEquals(survey.getStartAt(), surveyResponse.getStartAt());
		assertEquals(survey.getEndAt(), surveyResponse.getEndAt());
		assertEquals(survey.getId(), surveyResponse.getId());

		Carer carer = survey.getCarer();
		CarerResponse carerResponse = surveyResponse.getCarer();
		assertEquals(carer.getName(), carerResponse.getName());
		assertEquals(carer.getRegistry(), carerResponse.getRegistry());
		assertEquals(carer.getId(), carerResponse.getId());

		Patient patient = survey.getPatient();
		PatientResponse patientResponse = surveyResponse.getPatient();
		assertEquals(patient.getName(), patientResponse.getName());
		assertEquals(patient.getRegistry(), patientResponse.getRegistry());
		assertEquals(patient.getId(), patientResponse.getId());
		assertEquals(patient.getBirth(), patientResponse.getBirth());
		assertEquals(patient.getAddress(), patientResponse.getAddress());
		assertEquals(patient.getGender().getValue(), patientResponse.getGender());

		List<Response> responses = survey.getResponses();
		Response response = responses.get(0);
		List<ResponseResponse> responsesResponse = surveyResponse.getResponses();
		ResponseResponse responseResponse = responsesResponse.get(0);
		assertEquals(response.getId(), responseResponse.getId());
		assertEquals(response.getFieldId(), responseResponse.getField());
		assertEquals(response.getResponse(), responseResponse.getResponse());
		assertEquals(response.getSurvey().getId(), survey.getId());
	}

	private Survey createSurvey() {
		Survey survey = new Survey();

		survey.setId(1L);
		survey.setStartAt(OffsetDateTime.of(2016, 3, 4, 13, 44, 33, 342, ZoneOffset.UTC));
		survey.setEndAt(OffsetDateTime.of(2016, 3, 4, 13, 44, 33, 342, ZoneOffset.UTC));

		Carer carer = new Carer();

		carer.setId(1L);
		carer.setName("Homecare Um");
		carer.setRegistry("R45BG0");
		survey.setCarer(carer);

		Patient patient = new Patient();
		patient.setBirth(LocalDate.of(2016, 8, 13));
		patient.setAddress("Rua Augusta, 123 - São Paulo - SP");
		patient.setGender(Gender.MALE);
		patient.setName("Fulano de Tal");
		patient.setRegistry("AD124G");
		survey.setPatient(patient);

		List<Response> responses = new ArrayList<Response>();

		Response response = new Response();

		response.setSurvey(survey);
		response.setResponse("resposta");
		response.setFieldId(1L);
		responses.add(response);
		survey.setResponses(responses);

		return survey;
	}
}
