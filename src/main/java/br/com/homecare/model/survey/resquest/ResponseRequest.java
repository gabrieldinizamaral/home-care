package br.com.homecare.model.survey.resquest;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ResponseRequest {

	@NotNull
	private Long field;

	@NotEmpty
	private String response;

	public Long getField() {
		return field;
	}

	public void setField(Long field) {
		this.field = field;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
