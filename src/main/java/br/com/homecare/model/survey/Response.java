package br.com.homecare.model.survey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Response {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long fieldId;
	
	@ManyToOne
	private Survey survey;

	private String response;

	public Long getId() {
		return id;
	}

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long field) {
		this.fieldId = field;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
