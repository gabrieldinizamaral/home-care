package br.com.homecare.model.survey.resquest;

import javax.validation.constraints.NotNull;

public class CarerRequest {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
