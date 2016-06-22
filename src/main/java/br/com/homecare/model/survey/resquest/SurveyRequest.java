package br.com.homecare.model.survey.resquest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.homecare.model.OffsetDateTimeCustomSerializer;

public class SurveyRequest {

	@NotNull @JsonSerialize(using = OffsetDateTimeCustomSerializer.class)
	private OffsetDateTime startAt;

	@NotNull @JsonSerialize(using = OffsetDateTimeCustomSerializer.class)
	private OffsetDateTime endAt;

	@Valid @NotNull
	private CarerRequest carer;

	@Valid @NotNull
	private PatientRequest patient;

	@Valid
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
