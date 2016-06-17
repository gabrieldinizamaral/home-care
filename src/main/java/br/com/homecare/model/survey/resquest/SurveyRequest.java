package br.com.homecare.model.survey.resquest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.homecare.model.OffsetDateTimeCustomSerializer;

public class SurveyRequest {

	@JsonSerialize(using = OffsetDateTimeCustomSerializer.class)
	private OffsetDateTime startAt;

	@JsonSerialize(using = OffsetDateTimeCustomSerializer.class)
	private OffsetDateTime endAt;

	private CarerRequest carer;
	
	private PatientRequest patient;
	
	private List<ResponseRequest> responses = new ArrayList<ResponseRequest>();

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

	public CarerRequest getCarer() {
		return carer;
	}

	public void setCarer(CarerRequest carer) {
		this.carer = carer;
	}

	public PatientRequest getPatient() {
		return patient;
	}

	public void setPatient(PatientRequest patient) {
		this.patient = patient;
	}

	public List<ResponseRequest> getResponses() {
		return responses;
	}

	public void setResponses(List<ResponseRequest> responses) {
		this.responses = responses;
	}

}
