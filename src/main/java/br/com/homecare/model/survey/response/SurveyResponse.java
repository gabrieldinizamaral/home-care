package br.com.homecare.model.survey.response;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.homecare.model.OffsetDateTimeCustomSerializer;
import br.com.homecare.model.patient.PatientResponse;

public class SurveyResponse {

	private Long id;
	
	@JsonSerialize(using = OffsetDateTimeCustomSerializer.class)
	private OffsetDateTime startAt;

	@JsonSerialize(using = OffsetDateTimeCustomSerializer.class)
	private OffsetDateTime endAt;

	private CarerResponse carer;
	
	private PatientResponse patient;
	
	private List<ResponseResponse> responses = new ArrayList<ResponseResponse>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getStartAt() {
		return startAt;
	}

	public void setStartAt(OffsetDateTime startAt) {
		this.startAt = startAt;
	}

	public OffsetDateTime getEndAt() {
		return endAt;
	}

	public void setEndAt(OffsetDateTime endAt) {
		this.endAt = endAt;
	}

	public CarerResponse getCarer() {
		return carer;
	}

	public void setCarer(CarerResponse carer) {
		this.carer = carer;
	}

	public PatientResponse getPatient() {
		return patient;
	}

	public void setPatient(PatientResponse patient) {
		this.patient = patient;
	}

	public List<ResponseResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<ResponseResponse> responses) {
		this.responses = responses;
	}

}
